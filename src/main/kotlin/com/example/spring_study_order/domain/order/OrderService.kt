package com.example.spring_study_order.domain.order

interface OrderService {
  fun registerOrder(registerOrder: OrderCommand.RegisterOrder): String
  fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest)
  fun retrieveOrder(orderToken: String): OrderInfo.Main
}