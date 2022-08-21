package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.item.payment.PaymentProcessor
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
  private val orderStore: OrderStore,
  private val orderReader: OrderReader,
  private val orderItemSeriesFactory: OrderItemSeriesFactory,
  private val paymentProcessor: PaymentProcessor,
) : OrderService {
  override fun registerOrder(registerOrder: OrderCommand.RegisterOrder): String {
    TODO("Not yet implemented")
  }

  override fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest) {
    TODO("Not yet implemented")
  }

  override fun retrieveOrder(orderToken: String): OrderInfo.Main {
    TODO("Not yet implemented")
  }
}