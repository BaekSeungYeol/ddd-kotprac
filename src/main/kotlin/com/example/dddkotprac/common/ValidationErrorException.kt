package com.example.dddkotprac.common

class ValidationErrorException(
    val errors: List<ValidationError>
): RuntimeException() {

}