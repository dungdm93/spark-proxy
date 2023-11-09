package org.apache.spark.kubernetes

import io.fabric8.kubernetes.api.model.Pod
import io.fabric8.kubernetes.client.dsl.{Gettable, Nameable, Namespaceable}
import io.fabric8.kubernetes.client.informers.ResourceEventHandler
import io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty
import io.k8s.sparkoperator.v1beta2.SparkApplication
import io.k8s.sparkoperator.v1beta2.sparkapplicationstatus.DriverInfo
import org.apache.spark.internal.Logging
import org.apache.spark.kubernetes.SparkApplicationHandler._

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
    val namespace = app.getMetadata.getNamespace
    val name = app.getMetadata.getName
    if (removed
      || Option(app.getStatus.getApplicationState).exists(_.getState != RUNNING_STATE)
      || isNullOrEmpty(app.getStatus.getSparkApplicationId)) {
      provider.removeSparkApp(namespace, name)
      return
    }

    val appId = app.getStatus.getSparkApplicationId
    val driverInfo = app.getStatus.getDriverInfo
    if (driverInfo == null) return

    getSparkUIHostPort(namespace, driverInfo) match {
      case Some((host, port)) =>
        val appInfo = new SparkApplicationInfo(
          appId = appId,
          appName = name,
          appNamespace = namespace,
          driverHost = host,
          driverPort = port,
        )
        provider.upsertSparkApp(appInfo)
      case _ =>
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
}
