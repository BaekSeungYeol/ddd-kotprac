package com.example.dddkotprac.order.domain

import com.example.dddkotprac.common.event.Event

class OrderCanceledEvent(
    val orderId: Long
): Event()