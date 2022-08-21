package com.example.spring_study_order.domain.item

import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup

interface ItemOptionSeriesFactory {
  fun store(command: ItemCommand.RegisterItemRequest, item: Item): List<ItemOptionGroup>
}