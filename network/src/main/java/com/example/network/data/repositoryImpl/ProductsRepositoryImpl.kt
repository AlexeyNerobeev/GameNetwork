package com.example.network.data.repositoryImpl

import android.util.Log
import com.example.network.data.dto.ProductsDto
import com.example.network.data.dto.ResponseProductsDto
import com.example.network.data.mappers.toModel
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.Product
import com.example.network.domain.model.ResponseProducts
import com.example.network.domain.repository.ProductsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//01.04.2026
//Алексей
//реализация репозитория продуктов
class ProductsRepositoryImpl(
    private val httpClient: HttpClient
): ProductsRepository {
    //получение списка продуктов с поиском
    override suspend fun getProducts(search: String, searchField: String): ResponseProducts {
        return withContext(Dispatchers.IO){
            try {
                val request = httpClient.get(HttpConstants.GET_PRODUCTS) {
                    parameter("filter", "($searchField ?~ '$search')")
                }
                val response = request.body<ResponseProductsDto>().toModel()
                Log.d("getProducts", request.status.toString() + response.toString())
                return@withContext response
            } catch (e: Exception) {
                Log.e("getProducts", e.message.toString())
                return@withContext ResponseProducts()
            }
        }
    }

    //получение информации о продукте
    override suspend fun getProductInfo(id: String): Product {
        return withContext(Dispatchers.IO){
            try {
                val request = httpClient.get(HttpConstants.GET_PRODUCT_INFO + id)
                val response = request.body<ProductsDto>().toModel()
                Log.d("getProductInfo", request.status.toString() + response.toString())
                return@withContext response
            } catch (e: Exception) {
                Log.e("getProductInfo", e.message.toString())
                return@withContext Product()
            }
        }
    }
}