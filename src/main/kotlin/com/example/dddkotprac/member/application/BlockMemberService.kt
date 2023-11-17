package com.example.dddkotprac.member.application

import com.example.dddkotprac.member.domain.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BlockMemberService(
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun block(memberId: Long) {
        val member = memberRepository.findByIdOrNull(memberId) ?: throw NoSuchElementException()
        member.block()
    }
}