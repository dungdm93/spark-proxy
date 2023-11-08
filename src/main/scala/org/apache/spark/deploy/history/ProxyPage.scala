package org.apache.spark.deploy.history

import org.apache.spark.status.api.v1.ApplicationInfo
import org.apache.spark.ui.{UIUtils, WebUIPage}

import javax.servlet.http.HttpServletRequest
import scala.xml.Node

private[history] class ProxyPage(provider: ApplicationHistoryProvider)
  extends WebUIPage("") {
  def render(request: HttpServletRequest): Seq[Node] = {
    val requestedIncomplete = Option(request.getParameter("showIncomplete"))
      .getOrElse("false").toBoolean

    val displayApplications = shouldDisplayApplications(requestedIncomplete)
    val eventLogsUnderProcessCount = 100
    val lastUpdatedTime = provider.getLastUpdatedTime()
    val providerConfig = provider.getConfig()
    val content =
      <script src={UIUtils.prependBaseUri(request, "/static/historypage-common.js")}></script> ++
        <script src={UIUtils.prependBaseUri(request, "/static/utils.js")}></script>
          <div>
            <div class="container-fluid">
              <ul class="list-unstyled">
                {providerConfig.map { case (k, v) => <li>
                <strong>
                  {k}
                  :</strong>{v}
              </li>
              }}
              </ul>{if (eventLogsUnderProcessCount > 0) {
              <p>There are
                {eventLogsUnderProcessCount}
                event log(s) currently being
                processed which may result in additional applications getting listed on this page.
                Refresh the page to view updates.</p>
            }}{if (lastUpdatedTime > 0) {
              <p>Last updated:
                <span id="last-updated">
                  {lastUpdatedTime}
                </span>
              </p>
            }}{<p>Client local time zone:
              <span id="time-zone"></span>
            </p>}{if (displayApplications) {
              <script src={UIUtils.prependBaseUri(
                request, "/static/dataTables.rowsGroup.js")}></script> ++
                <div id="history-summary"></div> ++
                <script src={UIUtils.prependBaseUri(request, "/static/historypage.js")}></script> ++
                <script>setAppLimit(1000)</script>
            } else if (requestedIncomplete) {
              <h4>No incomplete applications found!</h4>
            } else if (eventLogsUnderProcessCount > 0) {
              <h4>No completed applications found!</h4>
            } else {
              <h4>No completed applications found!</h4> ++ provider.getEmptyListingHtml()
            }}<a href={makePageLink(request, !requestedIncomplete)}>
              {if (requestedIncomplete) {
                "Back to completed applications"
              } else {
                "Show incomplete applications"
              }}
            </a>
            </div>
          </div>
    UIUtils.basicSparkPage(request, content, "History Server", true)
  }

  def shouldDisplayApplications(requestedIncomplete: Boolean): Boolean = {
    provider.getListing().exists(isApplicationCompleted(_) != requestedIncomplete)
  }

  private def makePageLink(request: HttpServletRequest, showIncomplete: Boolean): String = {
    UIUtils.prependBaseUri(request, "/?" + "showIncomplete=" + showIncomplete)
  }

  private def isApplicationCompleted(appInfo: ApplicationInfo): Boolean = {
    appInfo.attempts.nonEmpty && appInfo.attempts.head.completed
  }
}
