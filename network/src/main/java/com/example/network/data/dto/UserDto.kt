package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель User
@Serializable
data class UserDto(
    val collectionId: String = "",
    val collectionName: String = "",
    val created: String = "",
    val emailVisibility: Boolean = false,
    val firstname: String = "",
    val id: String = "",
    val lastname: String = "",
    val secondname: String = "",
    val updated: String = "",
    val verified: Boolean = false,
    val datebirthday: String = "",
    val gender: String = ""
)
