package com.example.spring_study_order.domain.order.item

import com.example.spring_study_order.domain.AbstractEntity
import javax.persistence.CascadeType
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Table(name = "order_item_option")
open class OrderItemOptionGroup(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id : Long,

  @ManyToOne
  @JoinColumn(name="order_item_id")
  val orderItem : OrderItem,
  val ordering : Int,
  val itemOptionGroupName : String,

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItemOptionGroup", cascade = [CascadeType.PERSIST])
  val orderItemOptionList : List<OrderItemOption> = listOf()


  ) : AbstractEntity() {
}