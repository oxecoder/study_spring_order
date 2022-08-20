package com.example.spring_study_order.domain.item

import com.example.spring_study_order.domain.item.option.ItemOption
import com.example.spring_study_order.domain.item.option.ItemOptionStore
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroupStore
import com.example.spring_study_order.domain.partner.PartnerReader

class ItemServiceImpl(
  private val partnerReader: PartnerReader,
  private val itemStore: ItemStore,
  private val itemReader: ItemReader,
  private val itemOptionGroupStore: ItemOptionGroupStore,
  private val itemOptionStore: ItemOptionStore,
) : ItemService {
  override fun registerItem(command: ItemCommand.RegisterItemRequest, partnerToken: String): String {
    val partner = partnerReader.getPartner(partnerToken)

    val initItem = command.toEntity(partner.id)
    val item = itemStore.store(initItem)

    command.itemOptionGroupRequestList.forEach {
      val initItemOptionGroup = ItemOptionGroup(
        item = item,
        ordering = it.ordering,
        itemOptionGroupName = it.itemOptionGroupName
      )

      val itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup)

      it.itemOptionRequestList.forEach { itemOption ->
        val initItemOption = ItemOption(
          itemOptionGroup = itemOptionGroup,
          ordering = itemOption.ordering,
          itemOptionName = itemOption.itemOptionName,
          itemOptionPrice = itemOption.itemOptionPrice
        )

        itemOptionStore.store(initItemOption)
      }
    }

    return item.itemToken
  }

  override fun changeOnSale(itemToken: String) {
    TODO("Not yet implemented")
  }

  override fun changeEndOfSale(itemToken: String) {
    TODO("Not yet implemented")
  }

  override fun retrieveItemInfo(itemToken: String): ItemInfo.Main {
    TODO("Not yet implemented")
  }
}