package com.example.network.domain.usecase

import com.example.network.domain.model.Product
import com.example.network.domain.repository.ProductsRepository

//01.04.2026
//Алексей
//usecase для получения информации о продукте
class GetProductInfoUseCase(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(id: String): Product{
        return productsRepository.getProductInfo(id)
    }
}