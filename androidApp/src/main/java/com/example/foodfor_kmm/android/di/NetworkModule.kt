package com.example.foodfor_kmm.android.di

import com.example.foodfor_kmm.dataSource.network.KtorClientFactory
import com.example.foodfor_kmm.dataSource.network.repositories.RecipeService
import com.example.foodfor_kmm.domain.repositories.RecipeServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRecipeService(httpClient: HttpClient): RecipeService = RecipeServiceImpl(httpClient)
}