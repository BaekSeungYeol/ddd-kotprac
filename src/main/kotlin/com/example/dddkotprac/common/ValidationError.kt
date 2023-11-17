package com.example.dddkotprac.common

class ValidationError(
    val name: String?,
    val code: String
) {

    fun hasName() = name != null

    companion object {
        fun of(code: String): ValidationError {
            return ValidationError(null, code)
        }

        fun of(name: String, code: String): ValidationError {
            return ValidationError(name, code)
        }
    }
}