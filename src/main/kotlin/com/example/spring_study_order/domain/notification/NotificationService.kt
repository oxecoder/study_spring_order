package com.example.spring_study_order.domain.notification

interface NotificationService {
  fun sendEmail(addr: String, title: String, desc: String)
  fun sendKakao(number: String, dse: String)
  fun sendSms(number: String, des: String)
}