package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель RequestRegister
@Serializable
data class RequestRegisterDto(
    val email: String = "",
    val password: String = "",
    val passwordConfirm: String = ""
)