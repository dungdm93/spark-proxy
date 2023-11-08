package org.apache.spark.deploy.history

import org.apache.spark.internal.Logging
import org.apache.spark.internal.config.History
import org.apache.spark.status.api.v1.{ApplicationInfo, UIRoot}
import org.apache.spark.ui.{SparkUI, WebUI}
import org.apache.spark.util.{ShutdownHookManager, SystemClock, Utils}
import org.apache.spark.{SecurityManager, SparkConf}

class ProxyServer(conf: SparkConf,
                  provider: ApplicationHistoryProvider,
                  securityManager: SecurityManager)
  extends WebUI(securityManager, securityManager.getSSLOptions("proxyServer"), ProxyServer.getUIPort(conf),
    conf, name = "ProxyServerUI")
    with Logging
    with UIRoot
    with ApplicationCacheOperations {

  private val retainedApplications = conf.get(History.RETAINED_APPLICATIONS)
  private val appCache = new ApplicationCache(this, retainedApplications, new SystemClock())

  override def initialize(): Unit = ???

  override def withSparkUI[T](appId: String, attemptId: Option[String])(fn: SparkUI => T): T =
    appCache.withSparkUI(appId, attemptId)(fn)

  override def getApplicationInfoList: Iterator[ApplicationInfo] =
    provider.getListing()

  override def getApplicationInfo(appId: String): Option[ApplicationInfo] =
    provider.getApplicationInfo(appId)

  override def checkUIViewPermissions(appId: String, attemptId: Option[String], user: String): Boolean =
    provider.checkUIViewPermissions(appId, attemptId, user)

  override def getAppUI(appId: String, attemptId: Option[String]): Option[LoadedAppUI] =
    provider.getAppUI(appId, attemptId)

  override def attachSparkUI(appId: String, attemptId: Option[String], ui: SparkUI, completed: Boolean): Unit = {
    assert(serverInfo.isDefined, "ProxyServer must be bound before attaching SparkUIs")
    ui.getHandlers.foreach { handler =>
      serverInfo.get.addHandler(handler, ui.securityManager)
    }
  }

  override def detachSparkUI(appId: String, attemptId: Option[String], ui: SparkUI): Unit = {
    assert(serverInfo.isDefined, "ProxyServer must be bound before detaching SparkUIs")
    ui.getHandlers.foreach(detachHandler)
    provider.onUIDetached(appId, attemptId, ui)
  }
}

object ProxyServer extends Logging {
  private val conf = new SparkConf()

  def main(args: Array[String]): Unit = {
    Utils.initDaemon(log)
    new HistoryServerArguments(conf, args)

    val securityManager = createSecurityManager(conf)
    val provider = createApplicationHistoryProvider(conf)
    val server = new ProxyServer(conf, provider, securityManager)
    server.initialize()
    server.bind()
    provider.start()

    ShutdownHookManager.addShutdownHook { () =>
      server.stop()
      provider.stop()
    }

    // Wait until the end of the world... or if the HistoryServer process is manually stopped
    while (true) {
      Thread.sleep(Int.MaxValue)
    }
  }

  private def createSecurityManager(conf: SparkConf): SecurityManager = {
    HistoryServer.initSecurity()
    val securityManager = HistoryServer.createSecurityManager(conf)

    securityManager
  }

  private def createApplicationHistoryProvider(conf: SparkConf): ApplicationHistoryProvider = {
    val providerName = conf.get(History.PROVIDER)
      .getOrElse(classOf[FsHistoryProvider].getName)
    val provider = Utils.classForName[ApplicationHistoryProvider](providerName)
      .getConstructor(classOf[SparkConf])
      .newInstance(conf)

    provider
  }

  def getUIPort(conf: SparkConf): Int =
    conf.get(History.HISTORY_SERVER_UI_PORT)
}
