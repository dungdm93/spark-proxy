package org.apache.spark.deploy.history

import org.apache.spark.internal.config.ConfigBuilder

private[spark] object Proxy {
  val PROVIDER = ConfigBuilder("spark.proxy.provider")
    .version("1.1.0")
    .stringConf
    .createOptional
}
