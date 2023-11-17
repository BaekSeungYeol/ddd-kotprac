package com.example.dddkotprac.order.application

import com.example.dddkotprac.order.domain.ShippingInfo

class OrderRequest(
    val orderProducts: List<OrderProduct>?,
    val ordererMemberId: Long?,
    val shippingInfo: ShippingInfo?,
) {
}