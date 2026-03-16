package com.example.network.domain.usecase

import com.example.network.domain.repository.SharedPrefsRepository

class LoadUserIdUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(): String{
        return sharedPrefsRepository.loadUserId()
    }
}