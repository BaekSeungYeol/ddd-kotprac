package com.example.dddkotprac.member.domain

data class PasswordChangedEvent(
    private val id: Long,
    private val newPassword: String
)