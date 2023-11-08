package org.apache.spark.kubernetes

import org.apache.spark.SparkConf
import org.apache.spark.deploy.history.ApplicationProxyProvider

class KubernetesProxyProvider(conf: SparkConf)
  extends ApplicationProxyProvider {
  override def getAddress(id: String): Option[String] = ???
}
