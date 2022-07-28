package com.example.spring_study_order.common.interceptor

import java.util.UUID
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

@Component
class CommonHttpRequestInterceptor : HandlerInterceptorAdapter() {
  override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
    var requestEventId = request.getHeader(HEADER_REQUEST_UUID_KEY)
    if (StringUtils.isEmpty(requestEventId)) {
      requestEventId = UUID.randomUUID().toString()
    }
    MDC.put(HEADER_REQUEST_UUID_KEY, requestEventId)
    return true
  }

  companion object {
    const val HEADER_REQUEST_UUID_KEY = "x-request-id"
  }
}
