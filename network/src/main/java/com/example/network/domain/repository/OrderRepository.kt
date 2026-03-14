package com.example.network.domain.repository

import com.example.network.domain.model.RequestOrder
import com.example.network.domain.model.ResponseOrder

interface OrderRepository {
    suspend fun createOrder(requestOrder: RequestOrder): ResponseOrder
}