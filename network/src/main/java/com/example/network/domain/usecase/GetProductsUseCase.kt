package com.example.network.domain.usecase

import com.example.network.domain.model.ResponseProducts
import com.example.network.domain.repository.ProductRepository

class GetProductsUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(filterField: String, filterValue: String): ResponseProducts{
        return productRepository.getProducts(
            filterField = filterField,
            filterValue = filterValue
        )
    }
}