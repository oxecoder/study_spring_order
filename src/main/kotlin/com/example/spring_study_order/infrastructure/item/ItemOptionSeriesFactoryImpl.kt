package com.example.spring_study_order.infrastructure.item

import com.example.spring_study_order.domain.item.Item
import com.example.spring_study_order.domain.item.ItemCommand
import com.example.spring_study_order.domain.item.ItemOptionSeriesFactory
import com.example.spring_study_order.domain.item.option.ItemOptionStore
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroupStore
import org.springframework.stereotype.Component

@Component
class ItemOptionSeriesFactoryImpl(
  private val itemOptionGroupStore: ItemOptionGroupStore,
  private val itemOptionStore: ItemOptionStore,

  ) : ItemOptionSeriesFactory {
  override fun store(command: ItemCommand.RegisterItemRequest, item: Item): List<ItemOptionGroup> {
    if (command.itemOptionGroupRequestList.isEmpty()) return listOf()

    return command.itemOptionGroupRequestList.map { group ->
      val initItemOptionGroup = group.toEntity(item)
      val itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup)

      group.itemOptionRequestList.forEach { option ->
        val initOption = option.toEntity(itemOptionGroup)
        itemOptionStore.store(initOption)
      }

      itemOptionGroup
    }
  }
}