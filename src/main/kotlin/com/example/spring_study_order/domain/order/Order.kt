package com.example.spring_study_order.domain.order

import com.example.spring_study_order.common.exception.IllegalStatusException
import com.example.spring_study_order.common.util.TokenGenerator
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
  val id: Long = 0,
  val orderToken: String = TokenGenerator.randomCharacterWithPrefix("prefix_order"),
  val userId: Long,
  val payMethod: String,

  val orderItemList: List<OrderItem> = listOf(),

  @Embedded
  val deliveryFragment: DeliveryFragment,
  val orderedAt: ZonedDateTime = ZonedDateTime.now(),

  @Enumerated(EnumType.STRING)
  var status: Status = Status.INIT,

  ) : AbstractEntity() {

  public enum class Status(val description: String) {
    INIT("주문시작"),
    ORDER_COMPLETE("주문완료"),
    DELIVERY_PREPARE("배송준비"),
    IN_DELIVERY("배송중"),
    DELIVERY_COMPLETE("배송완료")
  }


  fun calculateTotalAmount(): Int {
    return orderItemList.sumOf { it.calculateTotalAmount() }
  }

  fun orderComplete() {
    if (this.status != Status.INIT) throw IllegalStatusException()
    this.status = Status.ORDER_COMPLETE

  }

}