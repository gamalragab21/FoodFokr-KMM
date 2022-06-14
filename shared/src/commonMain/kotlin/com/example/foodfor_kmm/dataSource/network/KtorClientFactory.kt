package com.example.foodfor_kmm.dataSource.network

import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.dataSource.network.model.RecipeDto
import com.example.foodfor_kmm.domain.model.Recipe
import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient
}

fun RecipeDto.toRecipe(): Recipe {
    val dataTimeUtil = DataTimeUtil()
    return Recipe(pk,
        title,
        publisher,
        featuredImage,
        rating,
        sourceUrl,
        ingredients,
        dataTimeUtil.toLocalDate(longDateAdded.toDouble()),
        dataTimeUtil.toLocalDate(longDateUpdated.toDouble())
    )
}

fun List<RecipeDto>.toRecipeList(): List<Recipe> = map { it.toRecipe() }
