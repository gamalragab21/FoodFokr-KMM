package com.example.foodfor_kmm.android.presentation.screens.recipe_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipeListScreen(
    onSelectedRecipe: (Int) -> Unit,
) {

    LazyColumn {
        items(100) { recipeId ->
            Row(
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                       onSelectedRecipe(recipeId)
                    }
            ) {

                Text(modifier = Modifier.padding(16.dp),
                    text = "RecipeId= $recipeId"
                )
            }
        }
    }

}