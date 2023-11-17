package com.example.dddkotprac.order.domain

class OrderNotFoundException(id: Long): RuntimeException("$id not found")