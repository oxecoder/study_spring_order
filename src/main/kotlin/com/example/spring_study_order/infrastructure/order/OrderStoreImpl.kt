package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.order.Order
import com.example.spring_study_order.domain.order.OrderStore
import com.example.spring_study_order.domain.order.item.OrderItem
import com.example.spring_study_order.domain.order.item.OrderItemOption
import com.example.spring_study_order.domain.order.item.OrderItemOptionGroup
import org.springframework.stereotype.Component

@Component
class OrderStoreImpl(
  private val orderRepository: OrderRepository,
  private val orderItemRepository: OrderItemRepository,
  private val orderItemOptionGroupRepository: OrderItemOptionGroupRepository,
  private val orderItemOptionRepository: OrderItemOptionRepository,
) : OrderStore {
  override fun store(order: Order): Order {
    TODO("Not yet implemented")
  }

  override fun store(orderItem: OrderItem): OrderItem {
    TODO("Not yet implemented")
  }

  override fun store(orderItemOptionGroup: OrderItemOptionGroup): OrderItemOptionGroup {
    TODO("Not yet implemented")
  }

  override fun store(orderItemOption: OrderItemOption): OrderItemOption {
    TODO("Not yet implemented")
  }
}