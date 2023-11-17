package com.example.dddkotprac.member.domain

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member,Long> {
}