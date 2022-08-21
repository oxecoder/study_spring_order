package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.order.item.OrderItem
import com.example.spring_study_order.domain.order.item.OrderItemOption
import com.example.spring_study_order.domain.order.item.OrderItemOptionGroup

interface OrderStore {
  fun store(order: Order): Order
  fun store(orderItem: OrderItem): OrderItem
  fun store(orderItemOptionGroup: OrderItemOptionGroup): OrderItemOptionGroup
  fun store(orderItemOption: OrderItemOption): OrderItemOption
}