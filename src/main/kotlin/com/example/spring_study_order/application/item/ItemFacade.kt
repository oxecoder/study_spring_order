package com.example.spring_study_order.application.item

import com.example.spring_study_order.domain.item.ItemCommand
import com.example.spring_study_order.domain.item.ItemInfo
import com.example.spring_study_order.domain.item.ItemService
import com.example.spring_study_order.domain.notification.NotificationService

class ItemFacade(
  private val itemService: ItemService,
  private val notificationService: NotificationService,
) {
  fun registerItem(request: ItemCommand.RegisterItemRequest, partnerToken: String): String {
    return itemService.registerItem(request, partnerToken)
  }

  fun changeOnSaleItem(itemToken: String) {
    itemService.changeOnSale(itemToken)
  }

  fun changeEndOfSaleItem(itemToken: String) {
    itemService.changeEndOfSale(itemToken)
  }

  fun retrieveItemInfo(itemToken: String): ItemInfo.Main {
    return itemService.retrieveItemInfo(itemToken)
  }

}