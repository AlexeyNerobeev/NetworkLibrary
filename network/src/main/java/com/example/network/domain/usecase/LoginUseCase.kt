package com.example.network.domain.usecase

import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(identity: String, password: String): ResponseAuth{
        return authRepository.login(RequestAuth(
            identity = identity,
            password = password
        ))
    }
}