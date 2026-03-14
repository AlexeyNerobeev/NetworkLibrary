package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RequestAuthDto(
    val identity: String,
    val password: String
)