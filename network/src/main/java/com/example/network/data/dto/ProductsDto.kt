package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель Products
@Serializable
data class ProductsDto(
    val id: String = "",
    val collectionId: String = "",
    val collectionName: String = "",
    val created: String = "",
    val updated: String = "",
    val title: String = "",
    val description: String ="",
    val price: Int = 0,
    val typeCloses: String = "",
    val type: String = "",
    val approximateCost: String = ""
)
