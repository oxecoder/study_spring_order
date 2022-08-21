package com.example.spring_study_order.domain.item

import com.example.spring_study_order.domain.item.option.ItemOptionStore
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroupStore
import com.example.spring_study_order.domain.partner.PartnerReader

class ItemServiceImpl(
  private val partnerReader: PartnerReader,
  private val itemStore: ItemStore,
  private val itemReader: ItemReader,
  private val itemOptionGroupStore: ItemOptionGroupStore,
  private val itemOptionStore: ItemOptionStore,
  private val itemOptionsSeriesFactory: ItemOptionSeriesFactory,
) : ItemService {
  override fun registerItem(command: ItemCommand.RegisterItemRequest, partnerToken: String): String {
    val partner = partnerReader.getPartner(partnerToken)

    val initItem = command.toEntity(partner.id)
    val item = itemStore.store(initItem)

    itemOptionsSeriesFactory.store(command, item)
    return item.itemToken
  }

  override fun changeOnSale(itemToken: String) {
    TODO("Not yet implemented")
  }

  override fun changeEndOfSale(itemToken: String) {
    TODO("Not yet implemented")
  }

  override fun retrieveItemInfo(itemToken: String): ItemInfo.Main {
    val item = itemReader.getItemBy(itemToken)
    val itemOptionGroupInfoList = itemReader.getItemOptionSeries(item)
    return ItemInfo.Main(item, itemOptionGroupInfoList)
  }
}