package com.example.dddkotprac.order.infra

import com.example.dddkotprac.order.domain.CancelPolicy
import com.example.dddkotprac.order.domain.Canceller
import com.example.dddkotprac.order.domain.Order
import org.springframework.stereotype.Component

@Component
class SecurityCancelPolicy: CancelPolicy {

    override fun hasCancellationPermission(order: Order, canceller: Canceller): Boolean {
        return true
    }
}