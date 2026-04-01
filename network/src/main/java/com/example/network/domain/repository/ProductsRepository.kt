package com.example.network.domain.repository

import com.example.network.domain.model.Product
import com.example.network.domain.model.ResponseProducts

//01.04.2026
//Алексей
//репозиторий для продуктов
interface ProductsRepository {
    suspend fun getProducts(search: String, searchField: String): ResponseProducts
    suspend fun getProductInfo(id: String): Product
}