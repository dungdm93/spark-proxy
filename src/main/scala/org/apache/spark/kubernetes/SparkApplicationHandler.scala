package org.apache.spark.kubernetes

import io.fabric8.kubernetes.api.model.{Pod, Quantity}
import io.fabric8.kubernetes.client.dsl.{Gettable, Nameable, Namespaceable}
import io.fabric8.kubernetes.client.informers.ResourceEventHandler
import io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty
import io.k8s.sparkoperator.v1beta2.SparkApplication
import io.k8s.sparkoperator.v1beta2.sparkapplicationstatus.DriverInfo
import org.apache.spark.internal.Logging
import org.apache.spark.kubernetes.SparkApplicationHandler._
import org.apache.spark.status.api.v1.{ApplicationAttemptInfo, ApplicationInfo}
import org.apache.spark.util.Utils

import java.math.BigDecimal
import java.time.Instant
import java.util.Date

class SparkApplicationHandler(podGetter: PodGetter, provider: KubernetesProxyProvider)
  extends ResourceEventHandler[SparkApplication]
    with Logging {
  override def onAdd(app: SparkApplication): Unit =
    syncSparkApp(app)

  override def onUpdate(oldApp: SparkApplication, newApp: SparkApplication): Unit = {
    if (oldApp.getMetadata.getResourceVersion == newApp.getMetadata.getResourceVersion) {
      logDebug(s"SparkApp=${newApp.getMetadata.getNamespace}/${newApp.getMetadata.getName} up-to-date")
      return
    }
    if (oldApp.getStatus.getSparkApplicationId != newApp.getStatus.getSparkApplicationId) {
      syncSparkApp(oldApp, removed = true)
    }
    syncSparkApp(newApp)
  }

  override def onDelete(app: SparkApplication, deletedFinalStateUnknown: Boolean): Unit =
    syncSparkApp(app, removed = true)

  private def syncSparkApp(app: SparkApplication, removed: Boolean = false): Unit = {
    if (app.getStatus == null) return
    val spec = app.getSpec
    val status = app.getStatus
    val namespace = app.getMetadata.getNamespace
    val name = app.getMetadata.getName
    if (removed
      || Option(status.getApplicationState).exists(_.getState != RUNNING_STATE)
      || isNullOrEmpty(status.getSparkApplicationId)) {
      provider.removeSparkApp(s"$namespace/$name")
      return
    }

    val appId = status.getSparkApplicationId
    val driverInfo = status.getDriverInfo
    if (driverInfo == null) return

    getSparkUIHostPort(namespace, driverInfo) match {
      case Some((host, port)) =>
        val startTime = if (status.getLastSubmissionAttemptTime != null)
          status.getLastSubmissionAttemptTime.toInstant else
          Instant.parse(app.getMetadata.getCreationTimestamp)
        val endTime = if (status.getTerminationTime != null)
          status.getTerminationTime.toInstant else
          Instant.now()
        val driver = Option(spec.getDriver)
        val executor = Option(spec.getExecutor)

        val attempt = ApplicationAttemptInfo(
          attemptId = Option(status.getSubmissionID),
          startTime = Date.from(startTime),
          endTime = Date.from(endTime),
          lastUpdated = new Date(),
          duration = endTime.toEpochMilli - startTime.toEpochMilli,
          sparkUser = "spark",
          completed = Option(status.getApplicationState).exists(s => FINISHED_STATES.contains(s.getState)),
          appSparkVersion = spec.getSparkVersion,
        )
        val appInfo = ApplicationInfo(
          id = appId,
          name = s"$namespace/$name",
          coresGranted = driver.map(_.getCores),
          maxCores = driver.flatMap(d => getCore(d.getCoreLimit)),
          coresPerExecutor = executor.map(_.getCores),
          memoryPerExecutorMB = executor.flatMap(e => getMemoryInMB(e.getMemory)),
          attempts = Seq(attempt),
        )
        val driverInfo = SparkDriverInfo(
          host = host,
          port = port,
        )
        provider.upsertSparkApp(SparkAppInfo(appInfo, driverInfo))
      case _ =>
    }
  }

  private def getCore(amount: String): Option[Int] = {
    if (isNullOrEmpty(amount)) return None
    try {
      val number = Quantity.parse(amount).getNumericalAmount
      Some(number.intValue())
    }
    catch {
      case _: Exception => None
    }
  }

  private def getMemoryInMB(amount: String): Option[Int] = {
    try {
      val a = if (isNullOrEmpty(amount)) "1g" else amount
      val number = Utils.memoryStringToMb(a)
      Some(number)
    } catch {
      case _: Exception => None
    }
  }

  private def getSparkUIHostPort(namespace: String, driverInfo: DriverInfo): Option[(String, Int)] = {
    // first, try to get host & port from webUIAddress
    val webUIAddr = driverInfo.getWebUIAddress
    if (!isNullOrEmpty(webUIAddr)) {
      return webUIAddr.split(':') match {
        case Array(host, port) =>
          if (isNullOrEmpty(port) || port == "0")
            Some(host, driverInfo.getWebUIPort)
          else
            Some(host, port.toInt)
        case _ => None
      }
    }

    // second, get host/port from driver pod
    val podName = driverInfo.getPodName
    val driver = getDriverPod(namespace, podName)
    if (driver == null) return None

    val host = driver.getStatus.getPodIP
    if (isNullOrEmpty(host)) return None

    getSparkUIPort(driver) match {
      case Some(port) => Some(host, port)
      case _ => None
    }
  }

  private def getDriverPod(namespace: String, podName: String): Pod = {
    if (isNullOrEmpty(podName)) {
      try {
        val pod = podGetter
          .inNamespace(namespace)
          .withName(podName)
          .get()
        return pod
      } catch {
        case e: Exception =>
          logError(s"Error while get pod $namespace/$podName from kubernetes", e)
          return null
      }
    }
    null
  }

  private def getSparkUIPort(pod: Pod): Option[Int] = {
    val container = pod.getSpec.getContainers.stream()
      .filter(_.getName == "spark-kubernetes-driver")
      .findFirst()
      .orElse(null)
    if (container == null) return None

    val port = container.getPorts.stream()
      .filter(_.getName == "spark-ui")
      .findFirst()
      .orElse(null)
    if (port == null) return None

    Some(port.getContainerPort)
  }
}

object SparkApplicationHandler {
  private type PodGetter = Namespaceable[_ <: Nameable[_ <: Gettable[Pod]]]

  val NEW_STATE = ""
  val SUBMITTED_STATE = "SUBMITTED"
  val RUNNING_STATE = "RUNNING"
  val COMPLETED_STATE = "COMPLETED"
  val FAILED_STATE = "FAILED"
  val FAILED_SUBMISSION_STATE = "SUBMISSION_FAILED"
  val PENDING_RERUN_STATE = "PENDING_RERUN"
  val INVALIDATING_STATE = "INVALIDATING"
  val SUCCEEDING_STATE = "SUCCEEDING"
  val FAILING_STATE = "FAILING"
  val UNKNOWN_STATE = "UNKNOWN"

  val FINISHED_STATES = Seq(COMPLETED_STATE, FAILED_STATE)
  val MB = BigDecimal.valueOf(1000000L)
}
