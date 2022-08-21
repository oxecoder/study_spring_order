package com.example.spring_study_order.infrastructure.order.payment

import com.example.spring_study_order.domain.item.payment.PayMethod
import com.example.spring_study_order.domain.order.OrderCommand
import org.springframework.stereotype.Component

@Component
class KakaoPayApiCaller : PaymentApiCaller {
  override fun support(paymentMethod: PayMethod): Boolean {
    return PayMethod.KAKAO_PAY == paymentMethod
  }

  override fun pay(request: OrderCommand.PaymentRequest) {
    TODO("Not yet implemented")
  }
}