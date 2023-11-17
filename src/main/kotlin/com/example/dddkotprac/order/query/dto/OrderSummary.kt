package com.example.dddkotprac.order.query.dto

import com.example.dddkotprac.common.model.Money
import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime
import java.time.ZonedDateTime


data class OrderSummary @QueryProjection constructor(
    val orderId: Long,
    val ordererId: Long,
    val ordererName: String,
    val totalAmounts: Money,
    val receiverName: String,
    val state: String,
    val orderDate: ZonedDateTime,
    val productId: Long,
    val productName: String
)
