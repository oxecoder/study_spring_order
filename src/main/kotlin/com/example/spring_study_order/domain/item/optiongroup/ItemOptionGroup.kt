package com.example.spring_study_order.domain.item.optiongroup

import com.example.spring_study_order.domain.AbstractEntity
import com.example.spring_study_order.domain.item.Item
import com.example.spring_study_order.domain.item.option.ItemOption
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "item_option_group")
open class ItemOptionGroup(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val ordering: Int,
  val itemOptionGroupName: String,

  /**
   * joinColumn을 해주어야 별도의 mapping table 없이 설정이 가능
   */
  @ManyToOne
  @JoinColumn(name = "item_id")
  val item: Item,

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = [CascadeType.PERSIST])
  val itemOptionList: List<ItemOption> = listOf(),

  ) : AbstractEntity() {

}