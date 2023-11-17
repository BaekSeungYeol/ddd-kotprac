package com.example.dddkotprac.order.infra

import com.example.dddkotprac.order.application.RefundService
import org.springframework.stereotype.Component

@Component
class ExternalRefundService: RefundService {

    override fun refund(orderId: Long) {
        TODO("Not yet implemented")
    }
}