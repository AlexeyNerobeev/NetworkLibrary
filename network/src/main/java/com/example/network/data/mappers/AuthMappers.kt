package com.example.network.data.mappers

import com.example.network.data.dto.RequestAuthDto
import com.example.network.data.dto.RequestRegisterDto
import com.example.network.data.dto.ResponseAuthDto
import com.example.network.data.dto.ResponseRegisterDto
import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.ResponseRegister

internal fun RequestRegister.toDto() = RequestRegisterDto(
    email = email,
    password = password,
    passwordConfirm = passwordConfirm
)

internal fun ResponseAuth.toDto() = ResponseAuthDto(
    token = token,
    record = record.toDto()
)

internal fun RequestAuth.toDto() = RequestAuthDto(
    identity = identity,
    password = password
)

internal fun ResponseAuthDto.toModel() = ResponseAuth(
    token = token,
    record = record.toModel()
)

internal fun ResponseRegister.tDto() = ResponseRegisterDto(
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    emailVisibility = emailVisibility,
    firstname = firstname,
    id = id,
    lastname = lastname,
    secondname = secondname,
    updated = updated,
    verified = verified,
    datebirthday = datebirthday,
    gender = gender
)

internal fun ResponseRegisterDto.toModel() = ResponseRegister(
    collectionId = collectionId,
    collectionName = collectionName,
    created = created,
    emailVisibility = emailVisibility,
    firstname = firstname,
    id = id,
    lastname = lastname,
    secondname = secondname,
    updated = updated,
    verified = verified,
    datebirthday = datebirthday,
    gender = gender
)