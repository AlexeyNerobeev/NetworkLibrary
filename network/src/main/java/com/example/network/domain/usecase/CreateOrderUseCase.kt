package com.example.network.domain.usecase

import com.example.network.domain.model.RequestOrder
import com.example.network.domain.model.ResponseOrder
import com.example.network.domain.repository.OrderRepository

class CreateOrderUseCase(private val orderRepository: OrderRepository) {
    suspend operator fun invoke(userId: String, productId: String, count: Int): ResponseOrder{
        return orderRepository.createOrder(RequestOrder(
            user_id = userId,
            product_id = productId,
            count = count
        ))
    }
}