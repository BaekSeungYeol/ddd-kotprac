package com.example.dddkotprac.order.domain

interface CancelPolicy {
    fun hasCancellationPermission(order: Order, canceller: Canceller): Boolean
}
