package com.example.foodfor_kmm.presentation.recipe_list_details

sealed class RecipeDetailsEvents {
    data class GetRecipe(val recipeId: Int) : RecipeDetailsEvents()
    object OnRemoveHeaderMessageFromQueue:RecipeDetailsEvents()
}