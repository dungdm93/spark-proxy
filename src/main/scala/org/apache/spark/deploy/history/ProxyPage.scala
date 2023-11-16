package org.apache.spark.deploy.history

import org.apache.spark.status.api.v1.ApplicationInfo
import org.apache.spark.ui.{UIUtils, WebUIPage}

import javax.servlet.http.HttpServletRequest
import scala.xml.Node

private[history] class ProxyPage(pageSize: Int, proxyProvider: ApplicationProxyProvider, historyProvider: ApplicationHistoryProvider)
  extends WebUIPage("") {
  def render(request: HttpServletRequest): Seq[Node] = {
    val content = scripts(request) ++ renderInfo() ++ renderRunningApplications() ++ renderCompletedApplications()
    UIUtils.basicSparkPage(request, content, "Proxy Server", true)
  }

  private def scripts(request: HttpServletRequest): Seq[Node] = {
    <script src={UIUtils.prependBaseUri(request, "/static/utils.js")}></script>
      <script src={UIUtils.prependBaseUri(request, "/static/dataTables.rowsGroup.js")}></script>
      <script src={UIUtils.prependBaseUri(request, "/static-proxy/proxypage.js")}></script>
      <script>setAppLimit(
        {pageSize}
        )</script>
  }

  private def renderInfo(): Seq[Node] = {
    val lastUpdatedTime = historyProvider.getLastUpdatedTime()
    val historyProviderConfig = historyProvider.getConfig()
    val proxyProviderConfig = proxyProvider.getConfig()
    val eventLogsUnderProcessCount = 100

    <div>
      <ul class="list-unstyled">
        {historyProviderConfig.map { case (k, v) =>
        <li>
          <strong>
            {k}
            :</strong>{v}
        </li>
      }}{proxyProviderConfig.map { case (k, v) =>
        <li>
          <strong>
            {k}
            :</strong>{v}
        </li>
      }}
      </ul>{if (eventLogsUnderProcessCount > 0) {
      <p>There are
        {eventLogsUnderProcessCount}
        event log(s) currently being processed which may result
        in additional applications getting listed on this page.
        Refresh the page to view updates.
      </p>
    }}{if (lastUpdatedTime > 0) {
      <p>Last updated:
        <span id="last-updated">
          {lastUpdatedTime}
        </span>
      </p>
    }}{<p>Client local time zone:
      <span id="time-zone"></span>
    </p>}
    </div>
  }

  private def renderRunningApplications(): Seq[Node] = {
    <div class="row">
      <div class="col-12">
        <span id="running-app" class="collapse-aggregated-activeApps collapse-table"
              onClick="collapseTable('collapse-aggregated-activeApps','aggregated-activeApps')">
          <h4>
            <span class="collapse-table-arrow arrow-open"></span>
            <a id="running-app-title">Running Applications (0)</a>
          </h4>
        </span>
        <div class="aggregated-activeApps collapsible-table">
          <div id="running-app-table"></div>
        </div>
      </div>
    </div>
  }

  private def renderCompletedApplications(): Seq[Node] = {
    <div class="row">
      <div class="col-12">
        <span id="completed-app" class="collapse-aggregated-completedApps collapse-table"
              onClick="collapseTable('collapse-aggregated-completedApps', 'aggregated-completedApps')">
          <h4>
            <span class="collapse-table-arrow arrow-open"></span>
            <a id="completed-app-title">Completed Applications (0)</a>
          </h4>
        </span>
        <div class="aggregated-completedApps collapsible-table">
          <div id="completed-app-table"></div>
        </div>
      </div>
    </div>
  }

  def shouldDisplayApplications(requestedIncomplete: Boolean): Boolean = {
    historyProvider.getListing().exists(isApplicationCompleted(_) != requestedIncomplete)
  }

  private def makePageLink(request: HttpServletRequest, showIncomplete: Boolean): String = {
    UIUtils.prependBaseUri(request, "/?" + "showIncomplete=" + showIncomplete)
  }

  private def isApplicationCompleted(appInfo: ApplicationInfo): Boolean = {
    appInfo.attempts.nonEmpty && appInfo.attempts.head.completed
  }
}
