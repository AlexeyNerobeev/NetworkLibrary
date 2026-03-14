package com.example.network.domain.usecase

import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseRegister
import com.example.network.domain.repository.AuthRepository

class RegisterUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String, passwordConfirm: String): ResponseRegister{
        return authRepository.register(RequestRegister(
            email = email,
            password = password,
            passwordConfirm = passwordConfirm
        ))
    }
}