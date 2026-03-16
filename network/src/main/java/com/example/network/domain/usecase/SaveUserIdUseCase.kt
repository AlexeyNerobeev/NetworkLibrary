package com.example.network.domain.usecase

import com.example.network.domain.repository.SharedPrefsRepository

class SaveUserIdUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(userId: String){
        sharedPrefsRepository.saveUserId(userId)
    }
}