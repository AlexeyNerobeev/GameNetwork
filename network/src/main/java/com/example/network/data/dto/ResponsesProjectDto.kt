package com.example.network.data.dto

import com.example.network.domain.model.Project
import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель ResponsesProject
@Serializable
data class ResponsesProjectDto(
    val page: Int = 0,
    val perPage : Int = 0,
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val items: List<ProjectDto> = listOf()
)
