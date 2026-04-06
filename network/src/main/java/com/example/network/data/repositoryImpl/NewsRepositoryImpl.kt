package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ResponsesNewsDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.ResponseNews
import com.example.network.domain.repository.NewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//01.04.2026
//Алексей
//реализация репозитория новостей
class NewsRepositoryImpl(
    private val httpClient: HttpClient
): NewsRepository {
    override suspend fun getNews(): Result<ResponseNews> {
        return withContext(Dispatchers.IO) {
            try {
                val request = httpClient.get(HttpConstants.GET_NEWS)
                val response = request.body<ResponsesNewsDto>().toModel()
                Log.d("getNews", request.status.toString() + response.toString())
                return@withContext Result.success(response)
            } catch (e: Exception) {
                Log.e("getNews", e.message.toString())
                return@withContext Result.failure(e)
            }
        }
    }
}