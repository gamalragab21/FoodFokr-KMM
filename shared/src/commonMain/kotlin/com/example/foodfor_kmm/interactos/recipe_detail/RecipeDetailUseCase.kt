package com.example.foodfor_kmm.interactos.recipe_detail

import com.example.foodfor_kmm.common.DataState
import com.example.foodfor_kmm.dataSource.cache.repositories.RecipeCacheService
import com.example.foodfor_kmm.dataSource.network.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeDetailUseCase constructor(
    private val recipeService: RecipeService,
    private val recipeCacheService: RecipeCacheService,
) {
    fun invoke(
        id: Int,
    ): Flow<DataState<Recipe>> = flow {
        // how we can handle loading?
        emit(DataState.loading(true))

        try {
//            val recipes = recipeService.get(id)
            val recipes = recipeCacheService.getRecipeById(id)
            println("RecipeDataUsecaseId: $id")
            println("RecipeDataUseCaseData: $recipes")
            emit(DataState.data(data = recipes))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown Error Occur"))
            // how we can handle an error?
        }

    }
}