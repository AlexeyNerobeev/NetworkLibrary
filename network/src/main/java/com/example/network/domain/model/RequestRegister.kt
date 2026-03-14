package com.example.network.domain.model

data class RequestRegister (
    val email: String,
    val password: String,
    val passwordConfirm: String
)