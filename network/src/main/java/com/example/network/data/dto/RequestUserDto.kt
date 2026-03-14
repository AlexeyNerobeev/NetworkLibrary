package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RequestUserDto(
    val email: String,
    val firstname: String,
    val secondname: String,
    val datebirthday: String,
    val gender: String
)
