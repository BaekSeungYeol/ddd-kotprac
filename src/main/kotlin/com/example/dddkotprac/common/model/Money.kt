package com.example.dddkotprac.common.model


data class Money(
    val value: Int
) {


    operator fun plus(other: Money): Money {
        return Money(this.value + other.value)
    }

    operator fun times(quantity: Int): Money {
        return Money(this.value * quantity)
    }
}