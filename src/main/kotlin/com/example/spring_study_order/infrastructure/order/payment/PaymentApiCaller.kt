package com.example.spring_study_order.infrastructure.order.payment

import com.example.spring_study_order.domain.item.payment.PayMethod
import com.example.spring_study_order.domain.order.OrderCommand

interface PaymentApiCaller {
  fun support(paymentMethod: PayMethod): Boolean
  fun pay(request: OrderCommand.PaymentRequest)
}