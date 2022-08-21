package com.example.spring_study_order.domain.order.item

import com.example.spring_study_order.domain.AbstractEntity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "order_item_option")
open class OrderItemOption(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long,

  @ManyToOne
  @JoinColumn(name = "order_item_option_group_id")
  val orderItemOptionGroup: OrderItemOptionGroup,
  val ordering: Int,
  val itemOptionName: String,
  val itemOptionPrice: Long,
) : AbstractEntity() {

}