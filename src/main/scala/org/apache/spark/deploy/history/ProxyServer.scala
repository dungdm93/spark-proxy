package org.apache.spark.deploy.history

import org.apache.spark.deploy.SparkHadoopUtil
import org.apache.spark.internal.Logging
import org.apache.spark.internal.config.{History, UI}
import org.apache.spark.status.api.v1.{ApiRootResource, ApplicationInfo, UIRoot}
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

  override def initialize(): Unit = {
    attachPage(new ProxyPage(provider))

    addStaticHandler(SparkUI.STATIC_RESOURCE_DIR)

    val apiHandler = ApiRootResource.getServletHandler(this)
    attachHandler(apiHandler)

    val historyHandler = HistoryServlet.getServletHandler(this)
    attachHandler(historyHandler)
  }

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

  private def initSecurity(): Unit = {
    // If we are accessing HDFS and it has security enabled (Kerberos), we have to login
    // from a keytab file so that we can access HDFS beyond the kerberos ticket expiration.
    // As long as it is using Hadoop rpc (hdfs://), a relogin will automatically
    // occur from the keytab.
    if (conf.get(History.KERBEROS_ENABLED)) {
      // if you have enabled kerberos the following 2 params must be set
      val principalName = conf.get(History.KERBEROS_PRINCIPAL)
        .getOrElse(throw new NoSuchElementException(History.KERBEROS_PRINCIPAL.key))
      val keytabFilename = conf.get(History.KERBEROS_KEYTAB)
        .getOrElse(throw new NoSuchElementException(History.KERBEROS_KEYTAB.key))
      SparkHadoopUtil.get.loginUserFromKeytab(principalName, keytabFilename)
    }
  }

  private def createSecurityManager(conf: SparkConf): SecurityManager = {
    initSecurity()
    if (conf.getBoolean(SecurityManager.SPARK_AUTH_CONF, false)) {
      logDebug(s"Clearing ${SecurityManager.SPARK_AUTH_CONF}")
      conf.set(SecurityManager.SPARK_AUTH_CONF, "false")
    }

    if (conf.get(UI.ACLS_ENABLE)) {
      logInfo(s"${UI.ACLS_ENABLE.key} is configured, " +
        s"clearing it and only using ${History.HISTORY_SERVER_UI_ACLS_ENABLE.key}")
      conf.set(UI.ACLS_ENABLE, false)
    }

    new SecurityManager(conf)
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
