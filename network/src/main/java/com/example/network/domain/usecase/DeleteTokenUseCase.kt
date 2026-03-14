package com.example.network.domain.usecase

import com.example.network.domain.repository.SharedPrefsRepository

class DeleteTokenUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(){
        sharedPrefsRepository.deleteToken()
    }
}