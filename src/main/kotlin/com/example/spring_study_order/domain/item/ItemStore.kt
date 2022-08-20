package com.example.spring_study_order.domain.item

interface ItemStore {
  fun store(initItem: Item): Item
}