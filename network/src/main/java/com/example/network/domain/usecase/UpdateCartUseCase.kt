package com.example.network.domain.usecase

import com.example.network.domain.model.RequestCart
import com.example.network.domain.model.ResponseCart
import com.example.network.domain.repository.CartRepository

class UpdateCartUseCase(private val cartRepository: CartRepository) {
    suspend operator fun invoke(user_id: String, product_id: String, count: Int, bucketId: String): ResponseCart{
        return cartRepository.updateCart(
            RequestCart(
                user_id = user_id,
                product_id = product_id,
                count = count
            ),
            bucketId = bucketId
        )
    }
}