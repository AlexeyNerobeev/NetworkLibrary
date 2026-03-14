package com.example.network.data.mappers

import com.example.network.data.dto.RequestUserDto
import com.example.network.data.dto.UserDto
import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User

internal fun User.toDto() = UserDto(
    id = id,
    firstname = firstname,
    lastname = lastname
)

internal fun UserDto.toModel() = User(
    id = id,
    firstname = firstname,
    lastname = lastname
)

internal fun RequestUser.toDto() = RequestUserDto(
    email = email,
    firstname = firstname,
    secondname = secondname,
    datebirthday = datebirthday,
    gender =gender
)

internal fun RequestUserDto.toModel() = RequestUser(
    email = email,
    firstname = firstname,
    secondname = secondname,
    datebirthday = datebirthday,
    gender = gender
)