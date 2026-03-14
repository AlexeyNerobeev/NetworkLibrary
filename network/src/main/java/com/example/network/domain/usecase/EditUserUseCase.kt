package com.example.network.domain.usecase

import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User
import com.example.network.domain.repository.UserRepository

class EditUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(
        userId: String,
        email: String,
        firstName: String,
        secondName: String,
        dateBirthday: String,
        gender: String
    ): User {
        return userRepository.editUser(
            requestUser = RequestUser(
                email = email,
                firstname = firstName,
                secondname = secondName,
                datebirthday = dateBirthday,
                gender = gender
            ),
            id = userId
        )
    }
}