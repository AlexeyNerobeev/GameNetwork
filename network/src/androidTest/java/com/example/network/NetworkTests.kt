package com.example.network

import androidx.compose.ui.platform.LocalContext
import androidx.test.core.app.ApplicationProvider
import com.example.network.data.repositoryImpl.AuthRepositoryImpl
import com.example.network.data.repositoryImpl.CurrentSessionRepositoryImpl
import com.example.network.data.repositoryImpl.NewsRepositoryImpl
import com.example.network.data.repositoryImpl.ProductsRepositoryImpl
import com.example.network.data.repositoryImpl.ProjectRepositoryImpl
import com.example.network.data.repositoryImpl.UserRepositoryImpl
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.model.RequestAuth
import com.example.network.domain.model.RequestRegister
import com.example.network.domain.model.RequestUser
import com.example.network.domain.usecase.GetNewsUseCase
import com.example.network.domain.usecase.GetProductInfoUseCase
import com.example.network.domain.usecase.GetProductsUseCase
import com.example.network.domain.usecase.GetProjectsUseCase
import com.example.network.domain.usecase.GetUserUseCase
import com.example.network.domain.usecase.LoginUseCase
import com.example.network.domain.usecase.RegistrationUseCase
import com.example.network.domain.usecase.SaveTokenUseCase
import com.example.network.domain.usecase.UpdateUserUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test

//01.04.2026
//Алексей
//класс тестов сетевой библиотеки
class NetworkTests {

    private val httpClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                this.explicitNulls
                this.encodeDefaults
            })
        }
        defaultRequest {
            header(
                key = "Authorization",
                value = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2xsZWN0aW9uSWQiOiJfcGJfdXNlcnNfYXV0aF8iLCJleHAiOjE3NzU2NDYzODQsImlkIjoib3RoNmp2MDh1bTlyd3V2IiwicmVmcmVzaGFibGUiOnRydWUsInR5cGUiOiJhdXRoIn0.4iomiiuzb8X0eJXY1lQAY6BB_4XAIx3SVR7rUNogpa4"
            )
            url(HttpConstants.BASE_URL)
        }
    }

    private val currentSessionRepository =
        CurrentSessionRepositoryImpl(ApplicationProvider.getApplicationContext())
    private val saveTokenUseCase = SaveTokenUseCase(currentSessionRepository)
    private val authRepository = AuthRepositoryImpl(httpClient, saveTokenUseCase)

    private val registrationUseCase = RegistrationUseCase(authRepository)
    private val loginUseCase = LoginUseCase(authRepository)
    private val userRepository = UserRepositoryImpl(httpClient)
    private val getUserUseCase = GetUserUseCase(userRepository)
    private val updateUserUseCase = UpdateUserUseCase(userRepository)
    private val newsRepository = NewsRepositoryImpl(httpClient)
    private val getNewsUseCase = GetNewsUseCase(newsRepository)
    private val productsRepository = ProductsRepositoryImpl(httpClient)
    private val getProductsUseCase = GetProductsUseCase(productsRepository)
    private val getProductInfoUseCase = GetProductInfoUseCase(productsRepository)
    private val projectRepository = ProjectRepositoryImpl(httpClient)
    private val getProjectsUseCase = GetProjectsUseCase(projectRepository)

    @Test
    fun registerTest() = runTest {
        registrationUseCase.invoke(
            RequestRegister(
                email = "qweasdzxc@mail.ru",
                password = "Password 123$",
                passwordConfirm = "Password 123$"
            )
        )
    }

    @Test
    fun loginTest() = runTest {
        loginUseCase.invoke(
            RequestAuth(
                identity = "qweasdzxc@mail.ru",
                password = "Password 123$"
            )
        )
    }

    @Test
    fun getUser() = runTest {
        getUserUseCase.invoke("oth6jv08um9rwuv")
    }

    @Test
    fun updateUser() = runTest {
        updateUserUseCase.invoke(
            id = "oth6jv08um9rwuv",
            RequestUser(
                email = "qweasdzxc@mail.ru",
                emailVisibility = false,
                firstname = "qwe",
                lastname = "qwe",
                secondname = "qwe",
                datebirthday = "2424",
                gender = "male"
            )
        )
    }

    @Test
    fun getNews() = runTest{
        getNewsUseCase.invoke()
    }

    @Test
    fun getProducts() = runTest {
        getProductsUseCase.invoke(search = "", "title")
    }

    @Test
    fun getProductInfo() = runTest {
        getProductInfoUseCase.invoke("eh4qumppov3nud1")
    }

    @Test
    fun getProjects() = runTest {
        getProjectsUseCase.invoke()
    }
}