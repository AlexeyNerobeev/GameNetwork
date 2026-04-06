package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель News
@Serializable
data class NewsDto(
    val collectionId: String = "",
    val collectionName: String = "",
    val id: String = "",
    val newsImage: String = "",
    val created: String = "",
    val updated: String = ""
)