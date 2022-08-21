package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.order.item.OrderItemOptionGroup
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemOptionGroupRepository : JpaRepository<OrderItemOptionGroup, Long> {}