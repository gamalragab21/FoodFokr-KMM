package com.example.foodfor_kmm.presentation.recipe_list

import com.example.foodfor_kmm.common.utils.GenericMessageInfo
import com.example.foodfor_kmm.common.utils.Queue
import com.example.foodfor_kmm.domain.model.Recipe

data class RecipeListState(
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val selectedCategory: FoodCategory? = null,
    val recipes: List<Recipe> = listOf(),
    val queue: Queue<GenericMessageInfo> = Queue(mutableListOf())

    )
