package com.example.foodfor_kmm.presentation.recipe_list

import com.example.foodfor_kmm.presentation.recipe_list_details.RecipeDetailsEvents

sealed class RecipeListEvent() {
    object LoadRecipes : RecipeListEvent()

    object NextPage : RecipeListEvent()

    data class OnQueryUpdate(val query: String) : RecipeListEvent()
    data class OnSelectCategory(val foodCategory: FoodCategory) : RecipeListEvent()

    object ExecuteNewSearch : RecipeListEvent()
    object OnRemoveHeaderMessageFromQueue: RecipeListEvent()

}
