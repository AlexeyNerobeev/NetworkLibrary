package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ResponseOrderDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants.CREATE_ORDER
import com.example.network.domain.model.RequestOrder
import com.example.network.domain.model.ResponseOrder
import com.example.network.domain.repository.OrderRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class OrderRepositoryImpl(
    private val httpClient: HttpClient
): OrderRepository {
    override suspend fun createOrder(requestOrder: RequestOrder): ResponseOrder {
        val request = httpClient.post(CREATE_ORDER) {
            contentType(ContentType.Application.Json)
            setBody(requestOrder.toDto())
        }
        Log.i("createOrder", request.status.toString())
        return request.body<ResponseOrderDto>().toModel()
    }
}