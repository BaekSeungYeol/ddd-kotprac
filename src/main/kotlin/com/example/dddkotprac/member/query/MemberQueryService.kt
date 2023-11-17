package com.example.dddkotprac.member.query

import com.example.dddkotprac.member.domain.Member
import com.example.dddkotprac.member.domain.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MemberQueryService(
    private val memberRepository: MemberRepository,
) {

    fun getMemberData(memberId: Long): Member {
        return memberRepository.findByIdOrNull(memberId) ?: throw NoSuchElementException()

    }
}