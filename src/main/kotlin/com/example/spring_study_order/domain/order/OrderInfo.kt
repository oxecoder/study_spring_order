package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.order.item.OrderItem
import com.example.spring_study_order.domain.order.item.OrderItemOptionGroup
import java.time.ZonedDateTime

sealed class OrderInfo {

  data class Main(
    val orderId: Long,
    val orderToken: String,
    val userId: Long,
    val payMethod: String,
    val totalAmount: Long,
    val deliverInfo: DeliveryInfo,
    val orderedAt: ZonedDateTime,
    val status: String,
    val statusDescription: String,
    val orderItemList: List<OrderItem>,
  ) : OrderInfo()

  data class DeliveryInfo(
    val receiverName: String,
    val receiverPhone: String,
    val receiverZipcode: String,
    val receiverAddress1: String,
    val receiverAddress2: String,
    val etcMessage: String,
  ) : OrderInfo()

  data class OrderItem(
    val orderCount: Int,
    val partnerId: Long,
    val itemId: Long,
    val itemName: String,
    val totalAmount: Long,
    val itemPrice: Long,
    val deliveryStatus: String,
    val deliveryStatusDescription: String,
    val orderItemOptionGroupList: List<OrderItemOptionGroup>,
  ) : OrderInfo()

  data class OrderItemOptionGroup(
    val ordering: Int,
    val itemOptionGroupName: String,
    val orderItemOptionList: List<OrderItemOption>,
  ) : OrderInfo()

  data class OrderItemOption(
    val ordering: Int,
    val itemOptionName: String,
    val itemOptionPrice: Long,
  ) : OrderInfo()

}