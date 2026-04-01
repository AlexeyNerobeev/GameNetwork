package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.UserDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.RequestUser
import com.example.network.domain.model.User
import com.example.network.domain.repository.UserRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//01.04.2026
//Алексей
//реализация репозитория пользователя
class UserRepositoryImpl(
    private val httpClient: HttpClient
): UserRepository {
    //метод получения информации о пользователе
    override suspend fun getUser(id: String): User {
        return withContext(Dispatchers.IO) {
            try {
                val request = httpClient.get(HttpConstants.GET_USER + id) {
                    contentType(ContentType.Application.Json)
                }
                val response = request.body<UserDto>().toModel()
                Log.d("getUser", request.toString() + response.toString())
                return@withContext response
            } catch (e: Exception) {
                Log.e("getUser", e.message.toString())
                return@withContext User()
            }
        }
    }

    //обновление пользователя
    override suspend fun updateUser(
        id: String,
        requestUser: RequestUser
    ): User {
        return withContext(Dispatchers.IO) {
            try {
                val request = httpClient.patch(HttpConstants.GET_USER + id) {
                    contentType(ContentType.Application.Json)
                    setBody(requestUser.toDto())
                }
                val response = request.body<UserDto>().toModel()
                Log.d("updateUser", request.status.toString() + response.toString())
                return@withContext response
            } catch (e: Exception) {
                Log.e("updateUser", e.message.toString())
                return@withContext User()
            }
        }
    }
}