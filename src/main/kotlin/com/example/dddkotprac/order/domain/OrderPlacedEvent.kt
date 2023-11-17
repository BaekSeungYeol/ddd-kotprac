package com.example.dddkotprac.order.domain

import java.time.ZonedDateTime

class OrderPlacedEvent(
    private val number: Long,
    private val orderer: Orderer,
    private val orderLines: List<OrderLine>,
    private val orderDate: ZonedDateTime
) {
}