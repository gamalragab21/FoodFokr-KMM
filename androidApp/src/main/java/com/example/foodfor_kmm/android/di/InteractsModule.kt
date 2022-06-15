package com.example.foodfor_kmm.android.di

import com.example.foodfor_kmm.dataSource.cache.repositories.RecipeCacheService
import com.example.foodfor_kmm.dataSource.network.repositories.RecipeService
import com.example.foodfor_kmm.interactos.recipe_detail.RecipeDetailUseCase
import com.example.foodfor_kmm.interactos.recipe_list.SearchRecipeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractsModule {

    @Singleton
    @Provides
    fun provideSearchRecipeUseCase(
        recipeService: RecipeService,
        recipeCacheService: RecipeCacheService,
    ): SearchRecipeUseCase = SearchRecipeUseCase(recipeService = recipeService,
        recipeCacheService = recipeCacheService)

    @Singleton
    @Provides
    fun provideRecipeUseCase(
        recipeService: RecipeService,
        recipeCacheService: RecipeCacheService,
    ): RecipeDetailUseCase = RecipeDetailUseCase(recipeService = recipeService,
        recipeCacheService = recipeCacheService)
}