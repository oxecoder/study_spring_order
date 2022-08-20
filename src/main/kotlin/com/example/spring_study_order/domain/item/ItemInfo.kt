package com.example.spring_study_order.domain.item

import com.example.spring_study_order.domain.item.option.ItemOption
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup

sealed class ItemInfo {

  data class Main(
    val itemToken: String,
    val partnerId: Long,
    val itemName: String,
    val itemPrice: Long,
    val status: Item.Status,
    val itemOptionGroupList: List<ItemOptionGroupInfo>,
  ) : ItemInfo() {
    constructor(item: Item, itemOptionGroupInfoList: List<ItemOptionGroupInfo>) : this(
      itemToken = item.itemToken,
      partnerId = item.partnerId,
      itemName = item.itemName,
      itemPrice = item.itemPrice,
      status = item.status,
      itemOptionGroupList = itemOptionGroupInfoList
    )
  }


  data class ItemOptionGroupInfo(
    val ordering: Int,
    val itemOptionGroupName: String,
    val itemOptionList: List<ItemOptionInfo>,
  ) : ItemInfo() {
    constructor(itemOptionGroup: ItemOptionGroup, itemOptionList: List<ItemOptionInfo>) : this(
      ordering = itemOptionGroup.ordering,
      itemOptionGroupName = itemOptionGroup.itemOptionGroupName,
      itemOptionList = itemOptionList
    )
  }

  data class ItemOptionInfo(
    val ordering: Int,
    val itemOptionName: String,
    val itemOptionPrice: Long,
  ) : ItemInfo() {
    constructor(itemOption: ItemOption) : this(
      ordering = itemOption.ordering,
      itemOptionName = itemOption.itemOptionName,
      itemOptionPrice = itemOption.itemOptionPrice
    )
  }

}