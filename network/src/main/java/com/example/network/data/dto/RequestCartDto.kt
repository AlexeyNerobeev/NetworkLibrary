package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RequestCartDto(
    val user_id: String,
    val product_id: String,
    val count: Int
)