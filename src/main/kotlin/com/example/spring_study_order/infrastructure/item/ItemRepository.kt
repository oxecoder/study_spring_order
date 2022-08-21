package com.example.spring_study_order.infrastructure.item

import com.example.spring_study_order.domain.item.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {
}