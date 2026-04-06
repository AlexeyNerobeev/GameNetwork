package com.example.network

import com.example.network.data.repositoryImpl.NewsRepositoryImpl
import com.example.network.domain.repository.NewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class Mock {
    private lateinit var mockWeServer: MockWebServer
    private lateinit var newsRepository: NewsRepository

    @Before
    fun startup(){
        val client = HttpClient(CIO){
            install(ContentNegotiation){
                json(Json { ignoreUnknownKeys = true })
            }
            defaultRequest {
                url(mockWeServer.url("/api/").toString())
            }
        }
        mockWeServer = MockWebServer()
        newsRepository = NewsRepositoryImpl(client)
    }

    @After
    fun tearDown(){
        mockWeServer.shutdown()
    }

    @Test
    fun getNews() = runTest {
        val json = """
            {
                "page": 1,
                "perPage": 10,
                "totalPages": 1,
                "totalItems": 1,
                "items": [
                    {
                        "id": "qwe",
                        "collectionId": "qwe",
                        "collectionName": "news",
                        "newsImage": "image.png",
                        "created": "2024-01-01",
                        "updated": "2024-01-01"
                    }
                ]
            }
        """.trimIndent()

        mockWeServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(json)
                .addHeader("Content-Type", "application/json")
        )

        val result = newsRepository.getNews()
        assertEquals(1, result.getOrThrow().items.size)

        val request = mockWeServer.takeRequest()
        assertEquals("/api/collections/news/records", request.path)
    }
}