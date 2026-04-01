package com.example.network.data.dto

import com.example.network.domain.model.User
import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель Auth
@Serializable
data class ResponseAuthDto(
    val record: UserDto = UserDto(),
    val token: String = ""
)