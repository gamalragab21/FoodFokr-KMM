package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.foodfor_kmm.domain.model.Recipe

@Composable
fun RecipeDetailScreen(recipe: Recipe?) {

    if (recipe == null) {
        Text("ERROR")
    } else {
        Text("RecipeDetailScreen: ${recipe.title}")
    }

}