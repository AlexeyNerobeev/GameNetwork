package com.example.network.domain.usecase

import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.repository.AuthRepository

//01.04.2026
//Алексей
//usecase для входа
class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(requestAuth: RequestAuth): ResponseAuth{
        return authRepository.login(requestAuth)
    }
}