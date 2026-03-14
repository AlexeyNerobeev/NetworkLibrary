package com.example.network.domain.model

data class ResponseAuth(
    val token: String,
    val record: User
)