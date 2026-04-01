package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель RequestUser
@Serializable
data class RequestUserDto(
    val email: String = "",
    val emailVisibility: Boolean = false,
    val firstname: String = "",
    val lastname: String = "",
    val secondname: String = "",
    val datebirthday: String = "",
    val gender: String = ""
)
