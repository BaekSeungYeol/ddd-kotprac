package com.example.dddkotprac.catalog.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository  : JpaRepository<Product, Long> {

}