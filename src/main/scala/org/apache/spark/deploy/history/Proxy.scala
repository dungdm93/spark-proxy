package org.apache.spark.deploy.history

import org.apache.spark.internal.config.ConfigBuilder

//noinspection TypeAnnotation
private[spark] object Proxy {
  val PROVIDER = ConfigBuilder("spark.proxy.provider")
    .version("1.0.0")
    .stringConf
    .createOptional

  val KUBERNETES_NAMESPACE = ConfigBuilder("spark.proxy.kubernetes.namespace")
    .version("1.0.0")
    .stringConf
    .createOptional

  val KUBERNETES_RESYNC_PERIOD = ConfigBuilder("spark.proxy.kubernetes.resyncPeriodMs")
    .version("1.0.0")
    .longConf
    .checkValue(_ > 1000L, "resyncPeriod need to be > 1000L")
    .createWithDefault(30 * 1000)
}
