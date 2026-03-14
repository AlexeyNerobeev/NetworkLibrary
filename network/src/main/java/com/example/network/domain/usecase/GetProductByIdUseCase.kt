package com.example.network.domain.usecase

import com.example.network.domain.model.Product
import com.example.network.domain.repository.ProductRepository

class GetProductByIdUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(id: String): Product{
        return productRepository.getProductById(id)
    }
}