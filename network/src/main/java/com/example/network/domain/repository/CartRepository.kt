package com.example.network.domain.repository

import com.example.network.domain.model.RequestCart
import com.example.network.domain.model.ResponseCart

interface CartRepository {
    suspend fun createCart(requestCart: RequestCart): ResponseCart
    suspend fun updateCart(requestCart: RequestCart, bucketId: String): ResponseCart
}