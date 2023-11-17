package com.example.dddkotprac.member.domain

import com.example.dddkotprac.common.event.Event
import com.example.dddkotprac.common.event.Events

class MemberBlockedEvent(
    val memberId: Long
) : Event()