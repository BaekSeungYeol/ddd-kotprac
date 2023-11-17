package com.example.dddkotprac.member.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Password(
    @Column(name = "password")
    val value: String
) {

    fun match(password: String): Boolean {
        return value == password
    }
}