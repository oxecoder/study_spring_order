package com.example.spring_study_order.domain.item.optiongroup

interface ItemOptionGroupStore {
  fun store(itemOptionGroup: ItemOptionGroup) : ItemOptionGroup
}