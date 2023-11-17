package com.example.dddkotprac.order.ui

import com.example.dddkotprac.order.domain.Order
import com.example.dddkotprac.order.domain.OrderRepository
import com.example.dddkotprac.order.query.dto.OrderSummary
import com.example.dddkotprac.order.query.dto.OrderView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TestController(
    private val orderRepository: OrderRepository
) {

    @GetMapping("/test")
    fun test(@RequestParam orderId: Long): List<OrderView> {
        return orderRepository.findOrderView(orderId)
    }

    @GetMapping("/test2")
    fun test2(@RequestParam orderId: Long): List<OrderSummary> {
        return orderRepository.findByIdOrderByOrderDateDescIdAsc(orderId)
    }
}
