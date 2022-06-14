package com.example.foodfor_kmm.interactos.recipe_detail

import com.example.foodfor_kmm.common.DataState
import com.example.foodfor_kmm.dataSource.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecipeDetailUseCase constructor(
    private val recipeService: RecipeService,
) {
    fun invoke(
        id: Int,
    ): Flow<DataState<Recipe>> = flow {
        // how we can handle loading?
        emit(DataState.loading(true))

        try {
            val recipes = recipeService.get(id)
            emit(DataState.data(data = recipes))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unkown"))
            // how we can handle an error?
        }

    }
}