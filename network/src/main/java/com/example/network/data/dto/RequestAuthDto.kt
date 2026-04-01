package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель RequestAuth
@Serializable
data class RequestAuthDto(
    val identity: String = "",
    val password: String = ""
)
