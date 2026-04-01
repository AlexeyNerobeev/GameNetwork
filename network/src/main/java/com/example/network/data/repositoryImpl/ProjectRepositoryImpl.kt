package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ResponsesProjectDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.ResponsesProject
import com.example.network.domain.repository.ProjectRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//01.04.2026
//Алексей
//реализация репозитория проектов
class ProjectRepositoryImpl(
    private val httpClient: HttpClient
): ProjectRepository {
    //получение списка проектов
    override suspend fun getProjects(): ResponsesProject {
        return withContext(Dispatchers.IO){
            try {
                val request = httpClient.get(HttpConstants.GET_PROJECTS)
                val response = request.body<ResponsesProjectDto>().toModel()
                Log.d("getProjects", request.status.toString() + response.toString())
                return@withContext response
            } catch (e: Exception) {
                Log.e("getProjects", e.message.toString())
                return@withContext ResponsesProject()
            }
        }
    }
}