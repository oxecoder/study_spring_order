package com.example.spring_study_order.domain.order.item

import com.example.spring_study_order.domain.AbstractEntity
import com.example.spring_study_order.domain.order.Order
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "order_item")
open class OrderItem(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id : Long,

  @ManyToOne
  @JoinColumn(name="order_id")
  val order : Order,
  val orderCount : Int,
  val partnerId : Long,
  val itemId : Long,
  val itemName : String,
  val itemToken : String,
  val itemPrice : Long,



) : AbstractEntity() {
}