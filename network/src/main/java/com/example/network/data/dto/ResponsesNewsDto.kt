package com.example.network.data.dto

import com.example.network.domain.model.News
import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель ResponsesNews
@Serializable
data class ResponsesNewsDto(
    val page: Int = 0,
    val perPage: Int = 0,
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val items: List<NewsDto> = listOf()
)