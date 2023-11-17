package com.example.dddkotprac.member.domain

import com.example.dddkotprac.common.event.Events
import com.example.dddkotprac.order.domain.ShippingInfo
import jakarta.persistence.*

@Entity
@Table(name = "member")
class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String,
    @Embedded
    var password: Password,
    val email: String,
    var blocked: Boolean
) {

    fun block() {
        this.blocked = true
        Events.raise(MemberBlockedEvent(id))
    }

    fun changePassword(oldPw: String, newPw: String) {
        if(!password.match(oldPw)) {
            throw IdPasswordNotMatchingException()
        }

        this.password = Password(newPw)
        Events.raise(PasswordChangedEvent(id, newPw))
    }

    fun changeAddress(newShippingInfo: ShippingInfo) {

    }

}