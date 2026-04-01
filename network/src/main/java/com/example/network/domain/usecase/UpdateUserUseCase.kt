package com.example.network.domain.usecase

import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User
import com.example.network.domain.repository.UserRepository

//01.04.2026
//Алексей
//usecase для обновления пользователя
class UpdateUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(id: String, requestUser: RequestUser): User{
        return userRepository.updateUser(id, requestUser)
    }
}