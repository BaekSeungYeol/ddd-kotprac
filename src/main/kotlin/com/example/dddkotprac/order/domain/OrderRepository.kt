package com.example.dddkotprac.order.domain

import com.example.dddkotprac.order.query.CustomOrderRepository
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order,Long>, CustomOrderRepository {

}
