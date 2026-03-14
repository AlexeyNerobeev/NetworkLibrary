package com.example.network.domain.model

data class RequestCart(
    val user_id: String,
    val product_id: String,
    val count: Int
)
