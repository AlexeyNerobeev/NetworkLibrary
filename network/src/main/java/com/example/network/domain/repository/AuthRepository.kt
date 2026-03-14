package com.example.network.domain.repository

import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.ResponseRegister

interface AuthRepository {
    suspend fun register(requestRegister: RequestRegister): ResponseRegister
    suspend fun login(requestAuth: RequestAuth): ResponseAuth
    suspend fun deleteUser(token: String)
}