package com.example.dddkotprac.order.domain

interface OrderService {
    fun createOrder(ordererMemberId: Long): Orderer
}