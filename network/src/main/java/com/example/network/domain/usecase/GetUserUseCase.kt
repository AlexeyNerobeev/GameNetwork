package com.example.network.domain.usecase

import com.example.network.domain.model.User
import com.example.network.domain.repository.UserRepository

//01.04.2026
//Алексей
//usecase для получения информации о пользователе
class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(id: String): User{
        return userRepository.getUser(id)
    }
}