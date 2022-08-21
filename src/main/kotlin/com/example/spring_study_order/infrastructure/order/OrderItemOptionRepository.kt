package com.example.spring_study_order.infrastructure.order

import com.example.spring_study_order.domain.order.item.OrderItemOption
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemOptionRepository : JpaRepository<OrderItemOption, Long> {}