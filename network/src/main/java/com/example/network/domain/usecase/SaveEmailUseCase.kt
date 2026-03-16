package com.example.network.domain.usecase

import com.example.network.domain.repository.SharedPrefsRepository

class SaveEmailUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(email: String){
        sharedPrefsRepository.saveEmail(email)
    }
}