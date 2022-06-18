package com.example.foodfor_kmm.presentation.recipe_list_details

import com.example.foodfor_kmm.common.utils.GenericMessageInfo
import com.example.foodfor_kmm.common.utils.Queue
import com.example.foodfor_kmm.domain.model.Recipe

data class RecipeDetailsState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val queue:Queue<GenericMessageInfo> = Queue(mutableListOf())
)