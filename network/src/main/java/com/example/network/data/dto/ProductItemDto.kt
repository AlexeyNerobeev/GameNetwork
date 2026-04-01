package com.example.network.data.dto

import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель ProductItem
@Serializable
data class ProductItemDto(
    val id: String = "",
    val title: String = "",
    val price: Int = 0,
    val typeCloses: String = "",
    val type: String = ""
)