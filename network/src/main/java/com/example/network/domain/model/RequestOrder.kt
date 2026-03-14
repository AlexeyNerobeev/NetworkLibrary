package com.example.network.domain.model

data class RequestOrder(
    val user_id: String,
    val product_id: String,
    val count: Int
)