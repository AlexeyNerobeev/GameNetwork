package com.example.network.domain.usecase

import com.example.network.domain.repository.CurrentSessionRepository

//01.04.2026
//Алексей
//usecase для сохранения токена
class SaveTokenUseCase(private val currentSessionRepository: CurrentSessionRepository) {
    operator fun invoke(token: String){
        currentSessionRepository.saveToken(token)
    }
}