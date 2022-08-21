package com.example.spring_study_order.domain.order.item

import com.example.spring_study_order.domain.AbstractEntity
import com.example.spring_study_order.domain.order.Order
import javax.persistence.CascadeType
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name = "order_items")
open class OrderItem(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

  @ManyToOne
  @JoinColumn(name = "order_id")
  val order: Order,
  val orderCount: Int,
  val partnerId: Long,
  val itemId: Long,
  val itemName: String,
  val itemToken: String,
  val itemPrice: Long,

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem", cascade = [CascadeType.PERSIST])
  val orderItemOptionGroupList: List<OrderItemOptionGroup> = listOf(),

  @Enumerated(EnumType.STRING)
  var deliveryStatus: DeliveryStatus,
) : AbstractEntity() {

  enum class DeliveryStatus(val description: String) {
    BEFORE_DELIVERY("배송전"),
    DELIVERY_PREPARE("배송준비중"),
    DELIVERY_COMPLETE("배송전"),
  }


  fun calculateTotalAmount(): Int {
//    val itemOptionTotalAmount = orderItemOptionGroupList.sumOf {
//
//    }
//    return (itemPrice.toInt() + itemOptionTotalAmount) * orderCount
    return 0
  }

}