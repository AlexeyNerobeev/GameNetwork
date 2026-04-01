package com.example.network.domain.model

//01.04.2026
//Алексей
//модель ResponsesNews
data class ResponseNews(
    val page: Int = 0,
    val perPage: Int = 0,
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val items: List<News> = listOf()
)
