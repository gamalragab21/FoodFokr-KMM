package com.example.foodfor_kmm.interactos.recipe_detail

import com.example.foodfor_kmm.common.DataState
import com.example.foodfor_kmm.common.utils.GenericMessageInfo
import com.example.foodfor_kmm.common.utils.UIComponentType
import com.example.foodfor_kmm.dataSource.cache.repositories.RecipeCacheService
import com.example.foodfor_kmm.dataSource.network.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import kotlinx.coroutines.delay
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
            delay(500)
            emit(DataState.data(data = recipes))
        } catch (e: Exception) {
            emit(DataState.error(
                GenericMessageInfo.Builder().id("RecipeDetails Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message ?: "UnKnown Error")
            ))            // how we can handle an error?
        }

    }
}