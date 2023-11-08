package org.apache.spark.deploy.history

import org.apache.spark.status.api.v1.UIRoot
import org.apache.spark.ui.UIUtils
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import scala.util.control.NonFatal

class HistoryServlet(uiRoot: UIRoot) extends HttpServlet {
  protected override def doGet(req: HttpServletRequest, res: HttpServletResponse): Unit = {
    res.setContentType("text/html;charset=utf-8")

    // Parse the URI created by getAttemptURI(). It contains an app ID and an optional
    // attempt ID (separated by a slash).
    val parts = Option(req.getPathInfo).getOrElse("").split("/")
    if (parts.length < 2) {
      res.sendRedirect("/")
    }

    val appId = parts(1)
    val attemptId = if (parts.length >= 3) {
      Some(parts(2))
    } else {
      uiRoot.getApplicationInfo(appId).flatMap(_.attempts.head.attemptId)
    }

    // Since we may have applications with multiple attempts mixed with applications with a
    // single attempt, we need to try both. Try the single-attempt route first, and if an
    // error is raised, then try the multiple attempt route.
    if (!loadAppUi(appId, None) && (attemptId.isEmpty || !loadAppUi(appId, attemptId))) {
      val msg = <div class="row">Application <code>{appId}</code> not found.</div>
      res.setStatus(HttpServletResponse.SC_NOT_FOUND)
      UIUtils.basicSparkPage(req, msg, "Not Found").foreach { n =>
        res.getWriter.write(n.toString)
      }
      return
    }

    // Note we don't use the UI retrieved from the cache; the cache loader above will register
    // the app's UI, and all we need to do is redirect the user to the same URI that was
    // requested, and the proper data should be served at that point.
    // Also, make sure that the redirect url contains the query string present in the request.
    val redirect = if (attemptId.isDefined) {
      req.getRequestURI.stripSuffix("/") + "/" + attemptId.get
    } else {
      req.getRequestURI
    }
    val query = Option(req.getQueryString).map("?" + _).getOrElse("")
    res.sendRedirect(res.encodeRedirectURL(redirect + query))
  }

  // SPARK-5983 ensure TRACE is not supported
  protected override def doTrace(req: HttpServletRequest, res: HttpServletResponse): Unit = {
    res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED)
  }

  private def loadAppUi(appId: String, attemptId: Option[String]): Boolean = {
    try {
      uiRoot.withSparkUI(appId, attemptId) { _ =>
        // Do nothing, just force the UI to load.
      }
      true
    } catch {
      case NonFatal(e: NoSuchElementException) =>
        false
    }
  }
}

object HistoryServlet {
  def getServletHandler(uiRoot: UIRoot): ServletContextHandler = {
    val servlet = new HistoryServlet(uiRoot)
    val handler = new ServletContextHandler
    handler.setContextPath(HistoryServer.UI_PATH_PREFIX)
    handler.addServlet(new ServletHolder(servlet), "/*")

    handler
  }
}
