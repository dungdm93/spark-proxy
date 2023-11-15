package org.apache.spark.deploy.history

import org.apache.spark.status.api.v1.ApplicationInfo

abstract class ApplicationProxyProvider {
  def stop(): Unit = {}

  def start(): Unit = {}

  def getConfig(): Map[String, String] = Map()

  def getAddress(id: String): Option[String]

  def getListing(): Iterator[ApplicationInfo]
}
