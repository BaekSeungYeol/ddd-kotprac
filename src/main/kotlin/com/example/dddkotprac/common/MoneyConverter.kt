package com.example.dddkotprac.common

import com.example.dddkotprac.common.model.Money
import jakarta.persistence.AttributeConverter

class MoneyConverter: AttributeConverter<Money, Int> {

    override fun convertToDatabaseColumn(money: Money?): Int? {
        return money?.value
    }

    override fun convertToEntityAttribute(value: Int?): Money? {
        return value?.let { Money(it) }
    }
}