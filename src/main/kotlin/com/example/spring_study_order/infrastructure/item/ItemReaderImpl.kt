package com.example.spring_study_order.infrastructure.item

import com.example.spring_study_order.domain.item.Item
import com.example.spring_study_order.domain.item.ItemInfo
import com.example.spring_study_order.domain.item.ItemReader
import org.springframework.stereotype.Component

@Component
class ItemReaderImpl(
  private val itemRepository: ItemRepository,
) : ItemReader {
  override fun getItemBy(itemToken: String): Item {
    TODO("Not yet implemented")
  }

  override fun getItemOptionSeries(item: Item): List<ItemInfo.ItemOptionGroupInfo> {
    TODO("Not yet implemented")
  }
}