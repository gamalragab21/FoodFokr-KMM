package com.example.foodfor_kmm.interactos.recipe_list

import com.example.foodfor_kmm.common.DataState
import com.example.foodfor_kmm.dataSource.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipeUseCase constructor(
    private val recipeService: RecipeService,
) {

    fun invoke(
        page: Int,
        query: String,
    ): Flow<DataState<List<Recipe>>> = flow {
        // how we can handle loading?
        emit(DataState.loading(true))

        try {
            val recipes = recipeService.search(page, query)
            emit(DataState.data(data = recipes))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unkown"))
            // how we can handle an error?
        }

    }


}