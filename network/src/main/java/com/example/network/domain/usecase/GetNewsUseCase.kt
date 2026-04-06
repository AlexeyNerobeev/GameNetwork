package com.example.network.domain.usecase

import com.example.network.domain.model.ResponseNews
import com.example.network.domain.repository.NewsRepository

//01.04.2026
//Алексей
//usecase для получения новостей
class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(): Result<ResponseNews>{
        return newsRepository.getNews()
    }
}