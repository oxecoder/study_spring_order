package com.example.spring_study_order.domain.item

interface ItemService {
  fun registerItem(command: ItemCommand.RegisterItemRequest, partnerToken: String): String
  fun changeOnSale(itemToken: String)
  fun changeEndOfSale(itemToken: String)
  fun retrieveItemInfo(itemToken: String): ItemInfo.Main
}