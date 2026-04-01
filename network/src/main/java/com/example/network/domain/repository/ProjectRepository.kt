package com.example.network.domain.repository

import com.example.network.domain.model.ResponsesProject

//01.04.2026
//Алексей
//репозиторий проектов
interface ProjectRepository {
    suspend fun getProjects(): ResponsesProject
}