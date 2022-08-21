package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.order.item.OrderItem

interface OrderItemSeriesFactory {
  fun store(order: Order, requestOrder: OrderCommand.RegisterOrder): List<OrderItem>
}