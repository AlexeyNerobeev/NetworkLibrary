package com.example.network.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductItemDto(
    val id: String,
    val title: String,
    val price: Int,
    //val typeCLoses: String,
    val type: String
)
