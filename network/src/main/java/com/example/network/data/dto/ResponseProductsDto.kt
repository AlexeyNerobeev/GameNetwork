package com.example.network.data.dto

import com.example.network.domain.model.ProductItem
import kotlinx.serialization.Serializable

//01.04.2026
//Алексей
//dto модель ResponseProducts
@Serializable
data class ResponseProductsDto(
    val page: Int = 0,
    val perPage: Int = 0,
    val totalPages: Int = 0,
    val totalItems: Int = 0,
    val items: List<ProductItemDto> = listOf()
)