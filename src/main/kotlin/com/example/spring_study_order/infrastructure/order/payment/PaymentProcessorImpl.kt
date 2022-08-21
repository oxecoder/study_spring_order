package com.example.spring_study_order.infrastructure.order.payment

import com.example.spring_study_order.domain.item.payment.PaymentProcessor
import com.example.spring_study_order.domain.order.Order
import com.example.spring_study_order.domain.order.OrderCommand
import org.springframework.stereotype.Component

@Component
class PaymentProcessorImpl(

) : PaymentProcessor {
  override fun pay(order: Order, request: OrderCommand.PaymentRequest) {
    TODO("Not yet implemented")
  }
}