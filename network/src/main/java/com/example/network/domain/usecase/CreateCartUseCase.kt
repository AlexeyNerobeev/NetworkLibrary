package com.example.network.domain.usecase

import android.util.Log
import com.example.network.domain.model.RequestCart
import com.example.network.domain.model.ResponseCart
import com.example.network.domain.repository.CartRepository

class CreateCartUseCase(private val cartRepository: CartRepository) {
    suspend operator fun invoke(user_id: String, product_id: String, count: Int): ResponseCart{
        return cartRepository.createCart(RequestCart(
            user_id = user_id,
            product_id = product_id,
            count = count
        ))
    }
}