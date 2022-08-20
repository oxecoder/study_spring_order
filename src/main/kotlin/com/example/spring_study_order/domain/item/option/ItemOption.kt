package com.example.spring_study_order.domain.item.option

import com.example.spring_study_order.domain.AbstractEntity
import com.example.spring_study_order.domain.item.optiongroup.ItemOptionGroup
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "item_group")
open class ItemOption(

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val ordering: Int,
  val itemOptionName: String,
  val itemOptionPrice: Long,

  @ManyToOne
  @JoinColumn(name = "item_option_group_id")
  val itemOptionGroup: ItemOptionGroup,

  ) : AbstractEntity() {
}