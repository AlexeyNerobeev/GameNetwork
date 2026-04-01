package com.example.network.domain.repository

import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User

//01.04.2026
//Алексей
//репозиторий пользователя
interface UserRepository {
    suspend fun getUser(id: String): User
    suspend fun updateUser(id: String, requestUser: RequestUser): User
}