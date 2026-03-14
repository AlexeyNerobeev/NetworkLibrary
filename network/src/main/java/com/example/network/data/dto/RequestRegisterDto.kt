package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RequestRegisterDto(
    val email: String,
    val password: String,
    val passwordConfirm: String
)