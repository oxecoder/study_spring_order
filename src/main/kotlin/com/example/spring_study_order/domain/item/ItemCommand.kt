package com.example.spring_study_order.domain.item

import com.example.spring_study_order.domain.item.option.ItemOption
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup

sealed class ItemCommand {

  data class RegisterItemRequest(
    val itemName: String,
    val itemPrice: Long,
    val itemOptionGroupRequestList: List<RegisterItemOptionGroupRequest>,

    ) : ItemCommand() {

    fun toEntity(partnerId: Long): Item {
      return Item(
        partnerId = partnerId,
        itemName = itemName,
        itemPrice = itemPrice
      )
    }

  }

  data class RegisterItemOptionGroupRequest(
    val ordering: Int,
    val itemOptionGroupName: String,
    val itemOptionRequestList: List<RegisterItemOptionRequest>,
  ) : ItemCommand() {

    fun toEntity(item: Item): ItemOptionGroup {
      return ItemOptionGroup(
        item = item,
        ordering = ordering,
        itemOptionGroupName = itemOptionGroupName
      )
    }
  }

  data class RegisterItemOptionRequest(
    val ordering: Int,
    val itemOptionName: String,
    val itemOptionPrice: Long,
  ) : ItemCommand() {

    fun toEntity(itemOptionGroup: ItemOptionGroup): ItemOption {
      return ItemOption(
        itemOptionGroup = itemOptionGroup,
        ordering = ordering,
        itemOptionName = itemOptionName,
        itemOptionPrice = itemOptionPrice
      )
    }
  }

}