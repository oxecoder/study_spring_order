package com.example.spring_study_order.domain.order

interface OrderReader {
  fun getOrder(orderToken: String): Order
}