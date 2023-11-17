package com.example.dddkotprac.order.query.dto

import com.example.dddkotprac.order.domain.OrderState
import com.querydsl.core.annotations.QueryProjection

data class OrderView @QueryProjection constructor(
    val orderId: Long,
    val state: OrderState,
    val memberName: String,
    val memberId: Long,
    val productName: String
) {
}
