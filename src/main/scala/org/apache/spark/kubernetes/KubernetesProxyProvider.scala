package org.apache.spark.kubernetes

import io.fabric8.kubernetes.client.KubernetesClientBuilder
import io.k8s.sparkoperator.v1beta2.SparkApplication
import org.apache.spark.SparkConf
import org.apache.spark.deploy.history.ApplicationProxyProvider

import scala.collection.mutable

class KubernetesProxyProvider(conf: SparkConf)
  extends ApplicationProxyProvider {
  private val client = new KubernetesClientBuilder().build()
  private val informerFactory = client.informers()
  private val nameToId = new mutable.HashMap[String, String]()
  private val idToInfo = new mutable.HashMap[String, SparkApplicationInfo]()

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

  override def getAddress(id: String): Option[String] =
    idToInfo.get(id).map(info => s"http://${info.driverHost}:${info.driverPort}")

  def removeSparkApp(namespace: String, name: String): Unit = {
    val key = s"$namespace/$name"
    nameToId.remove(key) match {
      case Some(id) => idToInfo.remove(id)
      case _ =>
    }
  }

  def upsertSparkApp(app: SparkApplicationInfo): Unit = {
    val key = s"${app.appNamespace}/${app.appName}"
    nameToId.put(key, app.appId) match {
      case Some(oldId) =>
        if (oldId != app.appId)
          idToInfo.remove(oldId)
      case _ =>
    }
    idToInfo.update(app.appId, app)
  }
}
