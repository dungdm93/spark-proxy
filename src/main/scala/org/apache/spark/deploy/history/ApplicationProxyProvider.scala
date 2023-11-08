package org.apache.spark.deploy.history

abstract class ApplicationProxyProvider {
  def stop(): Unit = {}

  def start(): Unit = {}

  def getAddress(id: String): Option[String]
}
