package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.order.Order
import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
  fun findByOrderToken(orderToken: String): Optional<Order>
}