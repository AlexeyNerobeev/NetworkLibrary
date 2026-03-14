package com.example.network.domain.usecase

import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.repository.AuthRepository

class DeleteUserUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(token: String){
        authRepository.deleteUser(token)
    }
}