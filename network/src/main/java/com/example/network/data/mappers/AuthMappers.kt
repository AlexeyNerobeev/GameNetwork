package com.example.network.data.mappers

import com.example.network.data.dto.RequestAuthDto
import com.example.network.data.dto.RequestRegisterDto
import com.example.network.data.dto.ResponseAuthDto
import com.example.network.data.dto.ResponseRegisterDto
import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.ResponseRegister

//01.04.2026
//Алексей
//mappers для авторизации и регистрации
internal fun RequestRegister.toDto() = RequestRegisterDto(
    email = email,
    password = password,
    passwordConfirm = passwordConfirm
)

internal fun RequestRegisterDto.toModel() = RequestRegister(
    email = email,
    password = password,
    passwordConfirm = passwordConfirm
)

internal fun ResponseRegister.toDto() = ResponseRegisterDto(
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

internal fun RequestAuth.toDto() = RequestAuthDto(
    identity = identity,
    password = password
)

internal fun RequestAuthDto.toModel() = RequestAuth(
    identity = identity,
    password = password
)

internal fun ResponseAuth.toDto() = ResponseAuthDto(
    record = record.toDto(),
    token = token
)

internal fun ResponseAuthDto.toModel() = ResponseAuth(
    record = record.toModel(),
    token = token
)