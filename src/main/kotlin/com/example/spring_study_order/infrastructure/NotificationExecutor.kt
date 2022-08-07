package com.example.spring_study_order.infrastructure

import com.example.spring_study_order.domain.notification.NotificationService
import org.springframework.stereotype.Component

@Component
class NotificationExecutor : NotificationService {
  override fun sendEmail(addr: String, title: String, desc: String) {
    print("sendEmail")
  }

  override fun sendKakao(number: String, dse: String) {
    print("sendKakao")
  }

  override fun sendSms(number: String, des: String) {
    print("sendSms")
  }
}