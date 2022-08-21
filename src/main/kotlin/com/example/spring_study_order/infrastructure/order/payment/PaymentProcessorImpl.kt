package com.example.spring_study_order.infrastructure.order.payment

import com.example.spring_study_order.domain.item.payment.PaymentProcessor
import com.example.spring_study_order.domain.order.Order
import com.example.spring_study_order.domain.order.OrderCommand
import org.springframework.stereotype.Component

@Component
class PaymentProcessorImpl(
  private val paymentApiCallerList: List<PaymentApiCaller>,
) : PaymentProcessor {
  override fun pay(order: Order, request: OrderCommand.PaymentRequest) {
    val apiCaller = routingApiCaller(request)
    apiCaller.pay(request)
  }

  private fun routingApiCaller(request: OrderCommand.PaymentRequest): PaymentApiCaller {
    return paymentApiCallerList.first { caller ->
      caller.support(request.payMethod)
    }
  }
}