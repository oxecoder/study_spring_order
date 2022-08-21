package com.example.spring_study_order.domain.order

import com.example.spring_study_order.domain.AbstractEntity
import com.example.spring_study_order.domain.order.fragment.DeliveryFragment
import com.example.spring_study_order.domain.order.item.OrderItem
import java.time.ZonedDateTime
import javax.persistence.Embedded
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "orders")
open class Order(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,
  val orderToken: String,
  val userId: Long,
  val payMethod: String,

  val orderItemList: List<OrderItem> = listOf(),

  @Embedded
  val deliveryFragment: DeliveryFragment,
  val orderedAt: ZonedDateTime,

  @Enumerated(EnumType.STRING)
  private val status: Status,

  ) : AbstractEntity() {

  public enum class Status(val description: String) {
    INIT("주문시작"),
    ORDER_COMPLETE("주문완료"),
    DELIVERY_PREPARE("배송준비"),
    IN_DELIVERY("배송중"),
    DELIVERY_COMPLETE("배송완료")
  }


}