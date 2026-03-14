package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.UserDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants.GET_USER
import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User
import com.example.network.domain.repository.UserRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserRepositoryImpl(
    private val httpClient: HttpClient
) : UserRepository {
    override suspend fun getUser(id: User): User {
        val user = httpClient.get(GET_USER + id.id)
            .body<UserDto>().toModel()
        Log.i("user", user.toString())
        return user
    }

    override suspend fun editUser(requestUser: RequestUser, id: String): User {
        val request = httpClient.patch(GET_USER + id) {
            contentType(ContentType.Application.Json)
            setBody(requestUser.toDto())
        }
        Log.i("editUser", request.status.toString())
        return request.body<UserDto>().toModel()
    }
}