package com.example.network.domain.model

//01.04.2026
//Алексей
//модель проекта
data class ResponsesProject(
    val page: Int = 0,
    val perPage : Int = 0,
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val items: List<Project> = listOf()
)