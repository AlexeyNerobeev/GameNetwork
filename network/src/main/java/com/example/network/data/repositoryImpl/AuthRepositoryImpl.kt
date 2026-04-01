package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ResponseAuthDto
import com.example.network.data.dto.ResponseRegisterDto
import com.example.network.data.mappers.toDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.ResponseAuth
import com.example.network.domain.model.ResponseRegister
import com.example.network.domain.repository.AuthRepository
import com.example.network.domain.usecase.SaveTokenUseCase
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//01.04.2026
//Алексей
//класс реализации репозитория авторизации
class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val saveTokenUseCase: SaveTokenUseCase
): AuthRepository {

    //функция регистрации
    override suspend fun registration(requestRegister: RequestRegister): ResponseRegister {
        return withContext(Dispatchers.IO) {
            try {
                val request = httpClient.post(HttpConstants.REGISTRATION) {
                    contentType(ContentType.Application.Json)
                    setBody(requestRegister.toDto())
                }
                Log.d("registration", request.status.toString() + request.toString())
                return@withContext request.body<ResponseRegisterDto>().toModel()
            } catch (e: Exception) {
                Log.e("registration", e.message.toString())
                return@withContext ResponseRegister()
            }
        }
    }

    //функция авторизации
    override suspend fun login(requestAuth: RequestAuth): ResponseAuth {
        return withContext(Dispatchers.IO) {
            try {
                val request = httpClient.post(HttpConstants.AUTHORIZATION) {
                    contentType(ContentType.Application.Json)
                    setBody(requestAuth.toDto())
                }
                val response = request.body<ResponseAuthDto>().toModel()
                Log.d("auth", request.status.toString() + response.toString())
                saveTokenUseCase.invoke(response.token)
                return@withContext response
            } catch (e: Exception) {
                Log.e("auth", e.message.toString())
                return@withContext ResponseAuth()
            }
        }
    }
}