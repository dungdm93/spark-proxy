package org.apache.spark.kubernetes

import io.fabric8.kubernetes.client.KubernetesClientBuilder
import io.k8s.sparkoperator.v1beta2.SparkApplication
import org.apache.spark.SparkConf
import org.apache.spark.deploy.history.ApplicationProxyProvider
import org.apache.spark.status.api.v1.ApplicationInfo

import scala.collection.mutable

class KubernetesProxyProvider(conf: SparkConf)
  extends ApplicationProxyProvider {
  private val client = new KubernetesClientBuilder().build()
  private val informerFactory = client.informers()
  private val nameToId = new mutable.HashMap[String, String]()
  private val idToInfo = new mutable.HashMap[String, SparkAppInfo]()

  override def start(): Unit = {
    val informer = informerFactory.sharedIndexInformerFor(classOf[SparkApplication], 30 * 1000)
    val podGetter = client.pods()
    val handler = new SparkApplicationHandler(podGetter, this)
    informer.addEventHandler(handler)

    informerFactory.startAllRegisteredInformers()
  }

  override def stop(): Unit = {
    informerFactory.stopAllRegisteredInformers()
  }

  override def getConfig(): Map[String, String] = {
    Map(
      "Spark Proxy" -> "Kubernetes",
      "Namespace" -> "default"
    )
  }

  override def getAddress(id: String): Option[String] =
    idToInfo.get(id).map(info => s"http://${info.driverInfo.host}:${info.driverInfo.port}")

  override def getListing(): Iterator[ApplicationInfo] =
    idToInfo.map { case (k, v) => v.appInfo }.iterator

  def removeSparkApp(name: String): Unit = {
    nameToId.remove(name) match {
      case Some(id) => idToInfo.remove(id)
      case _ =>
    }
  }

  def upsertSparkApp(app: SparkAppInfo): Unit = {
    val appInfo = app.appInfo
    nameToId.put(appInfo.name, appInfo.id) match {
      case Some(oldId) =>
        if (oldId != appInfo.id)
          idToInfo.remove(oldId)
      case _ =>
    }
    idToInfo.update(appInfo.id, app)
  }
}
