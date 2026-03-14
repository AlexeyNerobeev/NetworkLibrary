package com.example.network.domain.repository

import com.example.network.domain.model.Product
import com.example.network.domain.model.ResponseProducts

interface ProductRepository {
    suspend fun getProducts(filterField: String, filterValue: String): ResponseProducts
    suspend fun getProductById(id: String): Product
}