package com.example.spring_study_order.interfaces.item

import com.example.spring_study_order.domain.item.Item
import com.example.spring_study_order.domain.item.ItemCommand
import com.example.spring_study_order.domain.item.ItemInfo

sealed class ItemDto {
  data class RegisterItemRequest(
    val partnerToken: String,
    val itemName: String,
    val itemPrice: Long,
    val itemOptionGroupList: List<RegisterItemOptionGroupRequest>,
  ) : ItemDto() {
    fun toCommand(): ItemCommand.RegisterItemRequest {
      return ItemCommand.RegisterItemRequest(
        itemName = this.itemName,
        itemPrice = this.itemPrice,
        itemOptionGroupRequestList = itemOptionGroupList.map { optionGroupRequest ->
          ItemCommand.RegisterItemOptionGroupRequest(
            ordering = optionGroupRequest.ordering,
            itemOptionGroupName = optionGroupRequest.itemOptionGroupName,
            itemOptionRequestList = optionGroupRequest.itemOptionList.map { itemOptionRequest ->
              ItemCommand.RegisterItemOptionRequest(
                ordering = itemOptionRequest.ordering,
                itemOptionName = itemOptionRequest.itemOptionName,
                itemOptionPrice = itemOptionRequest.itemOptionPrice
              )
            }
          )
        },
      )
    }
  }

  data class RegisterItemOptionGroupRequest(
    val ordering: Int,
    val itemOptionGroupName: String,
    val itemOptionList: List<RegisterItemOptionRequest>,
  ) : ItemDto()

  data class RegisterItemOptionRequest(
    val ordering: Int,
    val itemOptionName: String,
    val itemOptionPrice: Long,
  ) : ItemDto()

  data class ChangeStatusItemRequest(
    val itemToken: String,
  ) : ItemDto()

  data class Main(
    val itemToken: String,
    val partnerId: Long,
    val itemName: String,
    val itemPrice: Long,
    val status: Item.Status,
    val itemOptionGroupList: List<ItemInfo.ItemOptionGroupInfo>,
  ) : ItemDto() {
    constructor(main: ItemInfo.Main) : this(
      itemToken = main.itemToken,
      partnerId = main.partnerId,
      itemName = main.itemName,
      itemPrice = main.itemPrice,
      status = main.status,
      itemOptionGroupList = main.itemOptionGroupList
    )
  }

  data class RegisterResponse(
    val itemToken: String,
  ) : ItemDto()


}