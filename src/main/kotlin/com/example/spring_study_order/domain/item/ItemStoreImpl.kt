package com.example.spring_study_order.domain.item

import com.example.spring_study_order.infrastructure.item.ItemRepository
import org.springframework.stereotype.Component

@Component
class ItemStoreImpl(
  private val itemRepository: ItemRepository,

  ) : ItemStore {
  override fun store(initItem: Item): Item {
    return itemRepository.save(initItem)
  }
}