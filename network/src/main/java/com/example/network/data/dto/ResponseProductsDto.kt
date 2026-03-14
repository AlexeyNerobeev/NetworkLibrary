package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponseProductsDto(
    val items: List<ProductItemDto>
)
