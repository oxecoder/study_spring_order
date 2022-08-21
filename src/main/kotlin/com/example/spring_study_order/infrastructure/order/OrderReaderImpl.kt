package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.order.Order
import com.example.spring_study_order.domain.order.OrderReader
import org.springframework.stereotype.Component

@Component
class OrderReaderImpl(
  private val orderRepository: OrderRepository,
) : OrderReader {
  override fun getOrder(orderToken: String): Order {
    TODO("Not yet implemented")
  }
}