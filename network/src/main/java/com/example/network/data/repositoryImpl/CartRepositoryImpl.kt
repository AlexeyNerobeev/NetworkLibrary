package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ResponseCartDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants.CREATE_CART
import com.example.network.data.utils.HttpConstants.UPDATE_CART
import com.example.network.domain.model.RequestCart
import com.example.network.domain.model.ResponseCart
import com.example.network.domain.repository.CartRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class CartRepositoryImpl(
    private val httpClient: HttpClient
): CartRepository {
    override suspend fun createCart(requestCart: RequestCart): ResponseCart {
        val request = httpClient.post(urlString = CREATE_CART) {
            contentType(ContentType.Application.Json)
            setBody(requestCart.toDto())
        }
        Log.i("createCart", request.status.toString())
        return request.body<ResponseCartDto>().toModel()
    }

    override suspend fun updateCart(requestCart: RequestCart, bucketId: String): ResponseCart {
        val request = httpClient.patch(UPDATE_CART + bucketId) {
            contentType(ContentType.Application.Json)
            setBody(requestCart.toDto())
        }
        Log.i("updateCart", request.status.toString())
        return request.body<ResponseCartDto>().toModel()
    }
}