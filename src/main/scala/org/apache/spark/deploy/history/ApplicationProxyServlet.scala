package org.apache.spark.deploy.history

import org.sparkproject.jetty.client.HttpClient
import org.sparkproject.jetty.client.api.Response
import org.sparkproject.jetty.client.http.HttpClientTransportOverHTTP
import org.sparkproject.jetty.proxy.ProxyServlet
import org.sparkproject.jetty.servlet.{ServletContextHandler, ServletHolder}

import java.net.URI
import javax.servlet.http.HttpServletRequest

// Copy from `org.apache.spark.ui.JettyUtils.createProxyHandler`
class ApplicationProxyServlet(idToUiAddress: String => Option[String]) extends ProxyServlet {
  override def newHttpClient(): HttpClient = {
    // SPARK-21176: Use the Jetty logic to calculate the number of selector threads (#CPUs/2),
    // but limit it to 8 max.
    val numSelectors = math.max(1, math.min(8, Runtime.getRuntime.availableProcessors() / 2))
    new HttpClient(new HttpClientTransportOverHTTP(numSelectors), null)
  }

  override def rewriteTarget(request: HttpServletRequest): String = {
    val path = request.getPathInfo
    if (path == null) return null

    val prefixTrailingSlashIndex = path.indexOf('/', 1)
    val prefix = if (prefixTrailingSlashIndex == -1) {
      path
    } else {
      path.substring(0, prefixTrailingSlashIndex)
    }
    val id = prefix.drop(1)

    // Query master state for id's corresponding UI address
    // If that address exists, try to turn it into a valid, target URI string
    // Otherwise, return null
    idToUiAddress(id)
      .map(createProxyURI(prefix, _, path, request.getQueryString))
      .filter(uri => uri != null && validateDestination(uri.getHost, uri.getPort))
      .map(_.toString)
      .orNull
  }

  override def filterServerResponseHeader(
                                           clientRequest: HttpServletRequest,
                                           serverResponse: Response,
                                           headerName: String,
                                           headerValue: String): String = {
    if (headerName.equalsIgnoreCase("location")) {
      val newHeader = createProxyLocationHeader(headerValue, clientRequest,
        serverResponse.getRequest.getURI)
      if (newHeader != null) {
        return newHeader
      }
    }
    super.filterServerResponseHeader(
      clientRequest, serverResponse, headerName, headerValue)
  }

  private def createProxyURI(prefix: String, target: String, path: String, query: String): URI = {
    if (!path.startsWith(prefix)) {
      return null
    }

    val uri = new StringBuilder(target)
    val rest = path.substring(prefix.length())

    if (rest.nonEmpty) {
      if (!rest.startsWith("/") && !uri.endsWith("/")) {
        uri.append("/")
      }
      uri.append(rest)
    }

    val queryString = if (query == null) {
      ""
    } else {
      s"?$query"
    }
    // SPARK-33611: use method `URI.create` to avoid percent-encoding twice on the query string.
    URI.create(uri.toString() + queryString).normalize()
  }

  private def createProxyLocationHeader(headerValue: String,
                                        clientRequest: HttpServletRequest,
                                        targetUri: URI): String = {
    val toReplace = targetUri.getScheme + "://" + targetUri.getAuthority
    if (headerValue.startsWith(toReplace)) {
      val id = clientRequest.getPathInfo.substring("/proxy/".length).takeWhile(_ != '/')
      val headerPath = headerValue.substring(toReplace.length)

      s"${clientRequest.getScheme}://${clientRequest.getHeader("host")}/proxy/$id$headerPath"
    } else {
      null
    }
  }
}

object ApplicationProxyServlet {
  // Return `org.sparkproject.jetty.servlet.ServletContextHandler` instead of `org.eclipse.jetty.servlet.ServletContextHandler`
  def getServletHandler(idToUiAddress: String => Option[String]): ServletContextHandler = {
    val servlet = new ApplicationProxyServlet(idToUiAddress)
    val handler = new ServletContextHandler
    val holder = new ServletHolder(servlet)
    handler.setContextPath("/proxy")
    handler.addServlet(holder, "/*")

    handler
  }
}
