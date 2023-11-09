package org.apache.spark.kubernetes

class SparkApplicationInfo(
  val appId: String,
  val appName: String,
  val appNamespace: String,
  val driverHost: String,
  val driverPort: Int,
)
