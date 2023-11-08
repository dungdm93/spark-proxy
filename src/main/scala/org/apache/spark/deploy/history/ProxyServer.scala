package org.apache.spark.deploy.history

import org.apache.spark.deploy.SparkHadoopUtil
import org.apache.spark.internal.Logging
import org.apache.spark.internal.config.{History, UI}
import org.apache.spark.status.api.v1.{ApiRootResource, ApplicationInfo, UIRoot}
import org.apache.spark.ui.{SparkUI, WebUI}
import org.apache.spark.util.{ShutdownHookManager, SystemClock, Utils}
import org.apache.spark.{SecurityManager, SparkConf}
import org.sparkproject.jetty.servlet.ServletContextHandler

class ProxyServer(conf: SparkConf,
                  proxyProvider: ApplicationProxyProvider,
                  historyProvider: ApplicationHistoryProvider,
                  securityManager: SecurityManager)
  extends WebUI(securityManager, securityManager.getSSLOptions("proxyServer"), ProxyServer.getUIPort(conf),
    conf, name = "ProxyServerUI")
    with Logging
    with UIRoot
    with ApplicationCacheOperations {

  private val retainedApplications = conf.get(History.RETAINED_APPLICATIONS)
  private val appCache = new ApplicationCache(this, retainedApplications, new SystemClock())

  // Reflections
  private val attachHandler = classOf[WebUI].getMethod("attachHandler", classOf[ServletContextHandler])
  private val detachHandler = classOf[WebUI].getMethod("detachHandler", classOf[ServletContextHandler])

  override def initialize(): Unit = {
    attachPage(new ProxyPage(proxyProvider, historyProvider))
    addStaticHandler(SparkUI.STATIC_RESOURCE_DIR)

    // spark-core shade `org.eclipse.jetty` to `org.sparkproject.jetty`.
    // So this way won't work, we need to use reflection instead.
    //    val apiHandler = ApiRootResource.getServletHandler(this)
    //    attachHandler(apiHandler)
    //
    //    val historyHandler = HistoryServlet.getServletHandler(this)
    //    attachHandler(historyHandler)

    val getServletHandler = ApiRootResource.getClass.getMethod("getServletHandler", classOf[UIRoot])
    val apiHandler = getServletHandler.invoke(ApiRootResource, this)
    attachHandler.invoke(this, apiHandler)

    val historyHandler = ApplicationHistoryServlet.getServletHandler(this)
    attachHandler.invoke(this, historyHandler)

    val proxyHandler = ApplicationProxyServlet.getServletHandler(proxyProvider.getAddress)
    attachHandler.invoke(this, proxyHandler)
  }

  override def withSparkUI[T](appId: String, attemptId: Option[String])(fn: SparkUI => T): T =
    appCache.withSparkUI(appId, attemptId)(fn)

  override def getApplicationInfoList: Iterator[ApplicationInfo] =
    historyProvider.getListing()

  override def getApplicationInfo(appId: String): Option[ApplicationInfo] =
    historyProvider.getApplicationInfo(appId)

  override def checkUIViewPermissions(appId: String, attemptId: Option[String], user: String): Boolean =
    historyProvider.checkUIViewPermissions(appId, attemptId, user)

  override def getAppUI(appId: String, attemptId: Option[String]): Option[LoadedAppUI] =
    historyProvider.getAppUI(appId, attemptId)

  override def attachSparkUI(appId: String, attemptId: Option[String], ui: SparkUI, completed: Boolean): Unit = {
    assert(serverInfo.isDefined, "ProxyServer must be bound before attaching SparkUIs")
    // ui.getHandlers.foreach(attachHandler)
    val handlers: Seq[Object] = ui.getHandlers
    handlers.foreach { handler =>
      attachHandler.invoke(this, handler)
    }
  }

  override def detachSparkUI(appId: String, attemptId: Option[String], ui: SparkUI): Unit = {
    assert(serverInfo.isDefined, "ProxyServer must be bound before detaching SparkUIs")
    // ui.getHandlers.foreach(detachHandler)
    val handlers: Seq[Object] = ui.getHandlers
    handlers.foreach { handler =>
      detachHandler.invoke(this, handler)
    }
    historyProvider.onUIDetached(appId, attemptId, ui)
  }
}

object ProxyServer extends Logging {
  private val conf = new SparkConf()

  def main(args: Array[String]): Unit = {
    Utils.initDaemon(log)
    new HistoryServerArguments(conf, args)

    val securityManager = createSecurityManager(conf)
    val proxyProvider = createApplicationProxyProvider(conf)
    val historyProvider = createApplicationHistoryProvider(conf)
    val server = new ProxyServer(conf, proxyProvider, historyProvider, securityManager)
    server.initialize()
    server.bind()
    proxyProvider.start()
    historyProvider.start()

    ShutdownHookManager.addShutdownHook { () =>
      server.stop()
      proxyProvider.stop()
      historyProvider.stop()
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

  private def createApplicationProxyProvider(conf: SparkConf): ApplicationProxyProvider = {
    case "spark-e90b4140dd3a40c0be3df102a870a855" => Some("http://10.6.4.5:4040")
    case _ => None
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
