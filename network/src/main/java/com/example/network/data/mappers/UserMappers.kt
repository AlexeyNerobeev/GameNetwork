package com.example.network.data.mappers

import com.example.network.data.dto.RequestUserDto
import com.example.network.data.dto.UserDto
import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User

//01.04.2026
//Алексей
//mappers для пользователя
internal fun User.toDto() = UserDto(
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

internal fun UserDto.toModel() = User(
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

internal fun RequestUser.toDto() = RequestUserDto(
    email = email,
    emailVisibility = emailVisibility,
    firstname = firstname,
    lastname = lastname,
    secondname = secondname,
    datebirthday = datebirthday,
    gender = gender
)

internal fun RequestUserDto.toModel() = RequestUser(
    email = email,
    emailVisibility = emailVisibility,
    firstname = firstname,
    lastname = lastname,
    secondname = secondname,
    datebirthday = datebirthday,
    gender = gender
)