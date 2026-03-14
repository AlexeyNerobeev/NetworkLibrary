package com.example.network.domain.usecase

import com.example.network.domain.model.User
import com.example.network.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(id: String): User{
        return userRepository.getUser(User(
            id = id,
            firstname = "",
            lastname = ""
        ))
    }
}