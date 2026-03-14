package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ResponseAuthDto
import com.example.network.data.dto.ResponseRegisterDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants.DELETE_USER
import com.example.network.data.utils.HttpConstants.LOGIN
import com.example.network.data.utils.HttpConstants.REGISTER
import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.ResponseRegister
import com.example.network.domain.repository.AuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(requestRegister: RequestRegister): ResponseRegister{
        val request = httpClient.post(REGISTER){
            contentType(ContentType.Application.Json)
            setBody(requestRegister.toDto())
        }
        Log.i("register", request.status.toString())
        return request.body<ResponseRegisterDto>().toModel()
    }

    override suspend fun login(requestAuth: RequestAuth): ResponseAuth {
        return httpClient.post(LOGIN) {
            contentType(ContentType.Application.Json)
            setBody(requestAuth.toDto())
        }.body<ResponseAuthDto>().toModel()
    }

    override suspend fun deleteUser(token: String) {
        httpClient.post(DELETE_USER + token) {
            contentType(ContentType.Application.Json)
        }
    }
}