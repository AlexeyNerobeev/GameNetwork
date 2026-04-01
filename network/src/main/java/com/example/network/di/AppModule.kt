package com.example.network.di

import android.content.Context
import com.example.network.data.repositoryImpl.AuthRepositoryImpl
import com.example.network.data.repositoryImpl.CurrentSessionRepositoryImpl
import com.example.network.data.repositoryImpl.NewsRepositoryImpl
import com.example.network.data.repositoryImpl.ProductsRepositoryImpl
import com.example.network.data.repositoryImpl.ProjectRepositoryImpl
import com.example.network.data.repositoryImpl.UserRepositoryImpl
import com.example.network.data.utils.HttpConstants
import com.example.network.domain.repository.AuthRepository
import com.example.network.domain.repository.CurrentSessionRepository
import com.example.network.domain.repository.NewsRepository
import com.example.network.domain.repository.ProductsRepository
import com.example.network.domain.repository.ProjectRepository
import com.example.network.domain.repository.UserRepository
import com.example.network.domain.usecase.GetNewsUseCase
import com.example.network.domain.usecase.GetProductInfoUseCase
import com.example.network.domain.usecase.GetProductsUseCase
import com.example.network.domain.usecase.GetProjectsUseCase
import com.example.network.domain.usecase.GetUserUseCase
import com.example.network.domain.usecase.LoginUseCase
import com.example.network.domain.usecase.RegistrationUseCase
import com.example.network.domain.usecase.SaveTokenUseCase
import com.example.network.domain.usecase.UpdateUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//01.04.2026
//Алексей
//класс внедрения зависимостей
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideHttpClient(currentSessionRepository: CurrentSessionRepository): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    this.explicitNulls
                    this.encodeDefaults
                })
            }
            defaultRequest {
                header(key = "Authorization",
                    value = "Bearer ${currentSessionRepository.loadToken()}")
                url(HttpConstants.BASE_URL)
            }
        }
    }

    @Provides
    fun provideAuthRepository(httpClient: HttpClient, saveTokenUseCase: SaveTokenUseCase): AuthRepository{
        return AuthRepositoryImpl(httpClient, saveTokenUseCase)
    }

    @Provides
    fun provideCurrentSessionRepository(@ApplicationContext context: Context): CurrentSessionRepository{
        return CurrentSessionRepositoryImpl(context)
    }

    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase{
        return LoginUseCase(authRepository)
    }

    @Provides
    fun provideRegistrationUseCase(authRepository: AuthRepository): RegistrationUseCase{
        return RegistrationUseCase(authRepository)
    }

    @Provides
    fun provideSaveTokenUseCase(currentSessionRepository: CurrentSessionRepository): SaveTokenUseCase{
        return SaveTokenUseCase(currentSessionRepository)
    }

    @Provides
    fun provideUserRepository(httpClient: HttpClient): UserRepository{
        return UserRepositoryImpl(httpClient)
    }

    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase{
        return GetUserUseCase(userRepository)
    }

    @Provides
    fun provideUpdateUserUseCase(userRepository: UserRepository): UpdateUserUseCase{
        return UpdateUserUseCase(userRepository)
    }

    @Provides
    fun provideNewsRepository(httpClient: HttpClient): NewsRepository{
        return NewsRepositoryImpl(httpClient)
    }

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsUseCase{
        return GetNewsUseCase(newsRepository)
    }

    @Provides
    fun provideProductsRepository(httpClient: HttpClient): ProductsRepository{
        return ProductsRepositoryImpl(httpClient)
    }

    @Provides
    fun provideGetProductsUseCase(productsRepository: ProductsRepository): GetProductsUseCase{
        return GetProductsUseCase(productsRepository)
    }

    @Provides
    fun provideGetProductInfo(productsRepository: ProductsRepository): GetProductInfoUseCase{
        return GetProductInfoUseCase(productsRepository)
    }

    @Provides
    fun provideProjectRepository(httpClient: HttpClient): ProjectRepository{
        return ProjectRepositoryImpl(httpClient)
    }

    @Provides
    fun provideGetProjectsUseCase(projectRepository: ProjectRepository): GetProjectsUseCase{
        return GetProjectsUseCase(projectRepository)
    }
}