package org.apache.spark.kubernetes

import org.apache.spark.status.api.v1.ApplicationInfo

case class SparkDriverInfo(host: String, port: Int)

case class SparkAppInfo(appInfo: ApplicationInfo, driverInfo: SparkDriverInfo)
