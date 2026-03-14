package com.example.network.domain.repository

import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User

interface UserRepository {
    suspend fun getUser(id: User): User
    suspend fun editUser(requestUser: RequestUser, id: String): User
}