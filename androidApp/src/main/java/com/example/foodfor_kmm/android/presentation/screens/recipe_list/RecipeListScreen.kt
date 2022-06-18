package com.example.foodfor_kmm.android.presentation.screens.recipe_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodfor_kmm.android.common.Constants
import com.example.foodfor_kmm.android.presentation.components.RecipeCard
import com.example.foodfor_kmm.android.presentation.components.SearchAppBar
import com.example.foodfor_kmm.android.presentation.components.shimmer.LoadingRecipeListShimmer
import com.example.foodfor_kmm.android.presentation.theme.AppTheme
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodfor_kmm.presentation.recipe_list.FoodCategoryUtil
import com.example.foodfor_kmm.presentation.recipe_list.RecipeListEvent
import com.example.foodfor_kmm.presentation.recipe_list.RecipeListState

@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onTriggerEvent: (RecipeListEvent) -> Unit,
    onSelectedRecipe: (Int) -> Unit,
) {

    AppTheme(displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveHeadFromQueue = {
            onTriggerEvent(RecipeListEvent.OnRemoveHeaderMessageFromQueue)
        }) {
        val foodCategories = remember { FoodCategoryUtil().getAllFoodCategories() }

        Scaffold(
            topBar = {
                SearchAppBar(query = state.query,
                    categories = foodCategories,
                    onSelectCategoryChange = {
                        onTriggerEvent(RecipeListEvent.OnSelectCategory(it))
                    },
                    selectedCategory = state.selectedCategory,
                    onQueryChange = {
                        onTriggerEvent(RecipeListEvent.OnQueryUpdate(it))
                    }) {
                    onTriggerEvent(RecipeListEvent.ExecuteNewSearch)
                }
            }
        ) {

            if (state.isLoading && state.recipes.isEmpty()) {
                // loading
                LoadingRecipeListShimmer(
                    Constants.RECIPE_IMAGE_HEIGHT.dp
                )
            } else if (state.recipes.isEmpty()) {

            } else {
                LazyColumn {
                    itemsIndexed(items = state.recipes) { index: Int, recipe: Recipe ->
                        if ((index + 1) >= (state.page * com.example.foodfor_kmm.common.Constants.RECIPE_PAGINATION_PAGE_SIZE) && !state.isLoading) {
                            onTriggerEvent(RecipeListEvent.NextPage)
                        }
                        RecipeCard(recipe = recipe) { onSelectedRecipe(recipe.id) }
                    }
                }
            }
        }
    }
}