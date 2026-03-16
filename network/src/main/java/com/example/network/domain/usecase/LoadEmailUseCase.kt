package com.example.network.domain.usecase

import com.example.network.domain.repository.SharedPrefsRepository

class LoadEmailUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(): String{
        return sharedPrefsRepository.loadEmail()
    }
}