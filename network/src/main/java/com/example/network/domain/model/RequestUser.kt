package com.example.network.domain.model

//01.04.2026
//Алексей
//модель RequestUser
data class RequestUser(
    val email: String = "",
    val emailVisibility: Boolean = false,
    val firstname: String = "",
    val lastname: String = "",
    val secondname: String = "",
    val datebirthday: String = "",
    val gender: String = ""
)