package org.apache.spark.deploy.history

import org.apache.spark.ui.{UIUtils, WebUIPage}

import javax.servlet.http.HttpServletRequest
import scala.xml.Node

private[history] class ProxyPage(pageSize: Int, proxyProvider: ApplicationProxyProvider, historyProvider: ApplicationHistoryProvider)
  extends WebUIPage("") {
  def render(request: HttpServletRequest): Seq[Node] = {
    val content = scripts(request) ++ renderInfo() ++ renderApplications("running-app") ++ renderApplications("completed-app")
    UIUtils.basicSparkPage(request, content, "Proxy Server", true)
  }

  private def scripts(request: HttpServletRequest): Seq[Node] = {
    // @formatter:off
    <script src={UIUtils.prependBaseUri(request, "/static/utils.js")}></script>
    <script src={UIUtils.prependBaseUri(request, "/static/dataTables.rowsGroup.js")}></script>
    <script src={UIUtils.prependBaseUri(request, "/static/historypage-common.js")}></script>
    <script src={UIUtils.prependBaseUri(request, "/static-proxy/proxypage.js")}></script>
    <script>
      setAppLimit({pageSize})
    </script>
    // @formatter:off
  }

  private def renderInfo(): Seq[Node] = {
    val lastUpdatedTime = historyProvider.getLastUpdatedTime()
    val historyProviderConfig = historyProvider.getConfig()
    val proxyProviderConfig = proxyProvider.getConfig()
    val eventLogsUnderProcessCount = historyProvider.getEventLogsUnderProcess()

    // @formatter:off
    <div>
      <ul class="list-unstyled">
        {historyProviderConfig.map { case (k, v) => <li><strong>{k}:</strong> <code>{v}</code></li> }}
        {if (lastUpdatedTime > 0) {
        <li><strong>Last updated:</strong> <code id="last-updated">{lastUpdatedTime}</code></li>
        }}
        {proxyProviderConfig.map { case (k, v) => <li><strong>{k}:</strong> <code>{v}</code></li> }}
        <li><strong>Client timezone:</strong> <code id="time-zone"></code></li>
      </ul>
      {if (eventLogsUnderProcessCount > 0) {
      <p>There are
        {eventLogsUnderProcessCount}
        event log(s) currently being processed which may result
        in additional applications getting listed on this page.
        Refresh the page to view updates.
      </p>
      }}
    </div>
    // @formatter:on
  }

  private def renderApplications(name: String): Seq[Node] = {
    <div class="row">
      <div class="col-12">
        <span id={name} class={s"collapse-table collapse-aggregated-${name}"}
              onClick={s"collapseTable('collapse-aggregated-${name}', 'aggregated-${name}')"}>
          <h4>
            <span class="collapse-table-arrow arrow-open"></span>
            <a id={s"$name-title"}>Running Applications (0)</a>
          </h4>
        </span>
        <div class={s"collapsible-table aggregated-${name}"}>
          <div id={s"$name-table"}></div>
        </div>
      </div>
    </div>
  }
}
