package com.example.dddkotprac.order.domain

data class Canceller(
    val memberId: Long
) {

    companion object {
        fun of(memberId: Long): Canceller {
            return Canceller(memberId)
        }
    }
}