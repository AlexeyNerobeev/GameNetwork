package com.example.network.data.repositoryImpl

import android.content.Context
import android.util.Log
import androidx.core.content.edit
import com.example.network.domain.repository.CurrentSessionRepository

//01.04.2026
//Алексей
//реализация репозитория текущей сессии
class CurrentSessionRepositoryImpl(
    context: Context
): CurrentSessionRepository {
    private val sharedPrefs = context.getSharedPreferences("Token", Context.MODE_PRIVATE)
    //сохранение токена
    override fun saveToken(token: String) {
        try {
            sharedPrefs.edit{ putString("token", token) }
        } catch (e: Exception) {
            Log.e("saveToken", e.message.toString())
        }
    }

    //получение токена
    override fun loadToken(): String? {
        try {
            val token = sharedPrefs.getString("token", null)
            Log.d("token", token.toString())
            return token
        } catch (e: Exception) {
            Log.e("loadToken", e.message.toString())
            return null
        }
    }
}