package com.example.network.domain.repository

import com.example.network.domain.model.ResponseNews

//01.04.2026
//Алексей
//репозиторий новостей
interface NewsRepository {
    suspend fun getNews(): ResponseNews
}