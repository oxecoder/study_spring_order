package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.item.payment.PayMethod
import com.example.spring_study_order.domain.order.item.OrderItem

sealed class OrderCommand {

  data class RegisterOrder(

    val userId: String,
    val payMethod: String,
    val receiverName: String,
    val receiverPhone: String,
    val receiverZipcode: String,
    val receiverAddress1: String,
    val receiverAddress2: String,
    val etcMessage: String,
    val orderItemList: List<RegisterOrderItem>,
  ) : OrderCommand()

  data class RegisterOrderItem(
    val orderCount: Int,
    val itemToken: String,
    val itemName: String,
    val itemPrice: Long,
    val orderItemOptionGroupList: List<RegisterOrderItemOptionGroup>,
  ) : OrderCommand()

  data class RegisterOrderItemOptionGroup(
    val ordering: Int,
    val itemOptionGroupName: String,
    val orderItemOptionLIst: List<RegisterOrderItemOption>,
  ) : OrderCommand()

  data class RegisterOrderItemOption(
    val ordering: Int,
    val itemOptionName: String,
    val itemOptionPrice: Long,
  ) : OrderCommand()

  data class PaymentRequest(
    val orderToken: String,
    val amount: Long,
    val payMethod: PayMethod,
  ) : OrderCommand()
}

