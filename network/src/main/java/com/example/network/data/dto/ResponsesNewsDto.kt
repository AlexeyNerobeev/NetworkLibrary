package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponsesNewsDto(
    val items: List<NewsDto>
)
