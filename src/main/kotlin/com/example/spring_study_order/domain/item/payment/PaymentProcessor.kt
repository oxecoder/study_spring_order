package com.example.spring_study_order.domain.item.payment

import com.example.spring_study_order.domain.order.Order
import com.example.spring_study_order.domain.order.OrderCommand

interface PaymentProcessor {
  fun pay(order: Order, request: OrderCommand.PaymentRequest)
}