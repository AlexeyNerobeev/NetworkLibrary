package com.example.network.domain.usecase

import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.User
import com.example.network.domain.repository.SharedPrefsRepository

class SaveTokenUseCase(private val sharedPrefsRepository: SharedPrefsRepository) {
    operator fun invoke(token: String, id: String){
        sharedPrefsRepository.saveToken(ResponseAuth(
            token = token,
            record = User(
                id = id,
                firstname = "",
                lastname = ""
            )
        ))
    }
}