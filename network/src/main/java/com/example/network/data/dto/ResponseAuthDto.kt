package com.example.network.data.dto

import com.example.network.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAuthDto(
    val token: String,
    val record: UserDto
)