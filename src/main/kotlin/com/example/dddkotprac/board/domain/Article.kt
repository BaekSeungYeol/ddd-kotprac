package com.example.dddkotprac.board.domain

import jakarta.persistence.*

@Entity
@Table(name = "article")
class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val content: String,
    val contentType: String
) {

}
