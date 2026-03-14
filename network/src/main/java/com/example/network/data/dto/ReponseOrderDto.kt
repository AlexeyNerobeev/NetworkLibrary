package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponseOrderDto(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val user_id: String,
    val product_id: String,
    val count: Int
)
