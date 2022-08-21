package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.item.ItemReader
import com.example.spring_study_order.domain.item.payment.PaymentProcessor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
  private val orderStore: OrderStore,
  private val orderReader: OrderReader,
  private val orderItemSeriesFactory: OrderItemSeriesFactory,
  private val paymentProcessor: PaymentProcessor,
) : OrderService {
  override fun registerOrder(registerOrder: OrderCommand.RegisterOrder): String {
    val order = orderStore.store(registerOrder.toEntity())
    orderItemSeriesFactory.store(order, requestOrder = registerOrder)
    return order.orderToken
  }

  @Transactional
  override fun paymentOrder(paymentRequest: OrderCommand.PaymentRequest) {
    val order = orderReader.getOrder(paymentRequest.orderToken)
    paymentProcessor.pay(order, paymentRequest)
    order.orderComplete()
  }

  override fun retrieveOrder(orderToken: String): OrderInfo.Main {
    TODO("Not yet implemented")
  }
}