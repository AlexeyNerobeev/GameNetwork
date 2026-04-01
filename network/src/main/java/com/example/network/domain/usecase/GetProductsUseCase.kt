package com.example.network.domain.usecase

import com.example.network.domain.model.ResponseProducts
import com.example.network.domain.repository.ProductsRepository

//01.04.2026
//Алексей
//usecase для получения списка продуктов с поиском
class GetProductsUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(search: String, searchField: String): ResponseProducts{
        return productsRepository.getProducts(search, searchField)
    }
}