package com.example.network.domain.model

//01.04.2026
//Алексей
//модель ResponseAuth
data class ResponseAuth(
    val record: User = User(),
    val token: String = ""
)