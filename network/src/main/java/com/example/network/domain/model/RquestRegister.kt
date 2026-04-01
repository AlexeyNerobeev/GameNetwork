package com.example.network.domain.model

//01.04.2026
//Алексей
//модель RequestRegister
data class RequestRegister(
    val email: String = "",
    val password: String = "",
    val passwordConfirm: String = ""
)
