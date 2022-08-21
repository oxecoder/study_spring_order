package com.example.spring_study_order.interfaces.item

import com.example.spring_study_order.application.item.ItemFacade
import com.example.spring_study_order.common.response.CommonResponse
import javax.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/v1/items")
class ItemApiController(
  private val itemFacade: ItemFacade,
) {

  @PostMapping
  fun registerItem(@RequestBody @Valid request: ItemDto.RegisterItemRequest): CommonResponse<ItemDto.RegisterResponse> {
    val itemCommand = request.toCommand()
    val itemToken = itemFacade.registerItem(itemCommand, request.partnerToken)
    val response = ItemDto.RegisterResponse(itemToken)
    return CommonResponse.Companion.success(response)
  }

  @PostMapping("/change-on-sales")
  fun changeOnSaleItem(
    @RequestBody @Valid request: ItemDto.ChangeStatusItemRequest,
  ): CommonResponse<String> {
    itemFacade.changeOnSaleItem(request.itemToken)
    return CommonResponse.success("OK")
  }

  @PostMapping("/change-end-of-sales")
  fun changeEndOfSaleItem(
    @RequestBody @Valid request: ItemDto.ChangeStatusItemRequest,
  ): CommonResponse<String> {
    itemFacade.changeEndOfSaleItem(request.itemToken)
    return CommonResponse.success("OK")
  }

  @GetMapping("/{itemToken}")
  fun retrieve(@PathVariable("itemToken") itemToken: String): CommonResponse<ItemDto.Main> {
    val info = itemFacade.retrieveItemInfo(itemToken)
    val response = ItemDto.Main(info)
    return CommonResponse.success(response)
  }
}