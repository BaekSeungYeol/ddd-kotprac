package com.example.dddkotprac.order.query

import com.example.dddkotprac.order.domain.Order
import com.example.dddkotprac.order.query.dto.OrderSummary
import com.example.dddkotprac.order.query.dto.OrderView

interface CustomOrderRepository {

    fun findOrderView(ordererId: Long): List<OrderView>
    fun findByIdOrderByOrderDateDescIdAsc(id: Long) : List<OrderSummary>
}