package com.example.foodfor_kmm.domain.repositories

import com.example.foodfor_kmm.common.Constants.BASE_URL
import com.example.foodfor_kmm.common.Constants.TOKEN
import com.example.foodfor_kmm.dataSource.network.model.RecipeDto
import com.example.foodfor_kmm.dataSource.network.model.RecipeSearchResponse
import com.example.foodfor_kmm.dataSource.network.toRecipe
import com.example.foodfor_kmm.dataSource.network.toRecipeList
import com.example.foodfor_kmm.dataSource.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class RecipeServiceImpl constructor(
    private val httpClient:HttpClient
) :RecipeService{
    override suspend fun search(page: Int, query: String): List<Recipe> {
        return httpClient.get{
            url("$BASE_URL/search?page=$page&query=$query")
            header("Authorization", TOKEN)
        }.body<RecipeSearchResponse>().results.toRecipeList()
    }

    override suspend fun get(recipeId: Int): Recipe {
         return httpClient.get{
            url("$BASE_URL/get?id=$recipeId")
            header("Authorization", TOKEN)
        }.body<RecipeDto>().toRecipe()
    }
}