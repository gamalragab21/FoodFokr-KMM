package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.foodfor_kmm.android.presentation.components.RecipeImage
import com.example.foodfor_kmm.android.presentation.theme.AppTheme
import com.example.foodfor_kmm.domain.model.Recipe

@Composable
fun RecipeDetailScreen(recipe: Recipe?) {
    AppTheme(displayProgressBar = false) {
        if (recipe == null) {
            Text("ERROR")
        } else {
            RecipeImage(url = recipe.sourceUrl,
                contentDescription = recipe.title)
        }
    }

}