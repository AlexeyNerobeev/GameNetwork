package com.example.network.domain.usecase

import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseRegister
import com.example.network.domain.repository.AuthRepository

//01.04.2026
//Алексей
//usecase для регистрации
class RegistrationUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(requestRegister: RequestRegister): ResponseRegister{
        return authRepository.registration(requestRegister)
    }
}