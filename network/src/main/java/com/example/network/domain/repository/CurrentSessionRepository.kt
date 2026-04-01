package com.example.network.domain.repository

//01.04.2026
//Алексей
//репозиторий текщуй сессии пользователя
interface CurrentSessionRepository {
    fun saveToken(token: String)
    fun loadToken(): String?
}