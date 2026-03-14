package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: String,
    val firstname: String,
    val lastname: String
)
