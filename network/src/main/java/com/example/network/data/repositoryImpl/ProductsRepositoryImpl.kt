package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ProductDto
import com.example.network.data.dto.ResponseProductsDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.data.utils.HttpConstants.GET_PRODUCTS
import com.example.network.domain.model.Product
import com.example.network.domain.model.ResponseProducts
import com.example.network.domain.repository.ProductRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ProductsRepositoryImpl(
    private val httpClient: HttpClient
): ProductRepository {
    override suspend fun getProducts(filterField: String, filterValue: String): ResponseProducts {
        val products = httpClient.get(GET_PRODUCTS) {
            parameter("filter", "($filterField ?~ '$filterValue')")
        }
        Log.i("getProducts", products.toString())
        return products.body<ResponseProductsDto>().toModel()
    }

    override suspend fun getProductById(id: String): Product {
        val request = httpClient.get(HttpConstants.GET_PRODUCT_BY_ID + id)
        Log.i("getProductById", request.status.toString())
        return request.body<ProductDto>().toModel()
    }
}