package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.item.ItemReader
import com.example.spring_study_order.domain.order.Order
import com.example.spring_study_order.domain.order.OrderCommand
import com.example.spring_study_order.domain.order.OrderItemSeriesFactory
import com.example.spring_study_order.domain.order.OrderStore
import com.example.spring_study_order.domain.order.item.OrderItem
import org.springframework.stereotype.Component

@Component
class OrderItemSeriesFactoryImpl(
  private val itemReader : ItemReader,
  private val orderStore: OrderStore
) : OrderItemSeriesFactory {
  override fun store(order: Order, requestOrder: OrderCommand.RegisterOrder): List<OrderItem> {
    TODO("Not yet implemented")
  }
}