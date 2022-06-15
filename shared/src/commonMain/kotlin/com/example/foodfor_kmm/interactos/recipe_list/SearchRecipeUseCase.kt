package com.example.foodfor_kmm.interactos.recipe_list

import com.example.foodfor_kmm.common.DataState
import com.example.foodfor_kmm.dataSource.cache.repositories.RecipeCacheService
import com.example.foodfor_kmm.dataSource.network.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipeUseCase constructor(
    private val recipeService: RecipeService,
    private val recipeCacheService: RecipeCacheService,
) {

    fun invoke(
        page: Int,
        query: String,
    ): Flow<DataState<List<Recipe>>> = flow {
        // how we can handle loading?
        emit(DataState.loading(true))

        try {
            val recipes = recipeService.search(page, query)
            println("RecipeListDataUseCaseRemote $recipes")

            recipeCacheService.insert(recipes)
            val cacheResult = if (query.isBlank()) {
                recipeCacheService.getAll(page)
            } else {
                recipeCacheService.search(query, page)
            }
            println("RecipeListDataUseCaseCache $cacheResult")
            emit(DataState.data(data = cacheResult))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown Error occur"))
            // how we can handle an error?
        }

    }


}