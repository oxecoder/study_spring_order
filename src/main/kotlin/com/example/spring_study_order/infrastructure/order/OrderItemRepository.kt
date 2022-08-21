package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.order.item.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Long> {}