package com.example.network.domain.repository

import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.ResponseRegister

//01.04.2026
//Алексей
//репозиторий авторизации
interface AuthRepository {
    suspend fun registration(requestRegister: RequestRegister): ResponseRegister
    suspend fun login(requestAuth: RequestAuth): ResponseAuth
}