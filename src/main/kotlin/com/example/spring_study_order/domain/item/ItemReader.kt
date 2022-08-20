package com.example.spring_study_order.domain.item

interface ItemReader {
  fun getItemBy(itemToken: String): Item
  fun getItemOptionSeries(item: Item): List<ItemInfo.ItemOptionGroupInfo>

}