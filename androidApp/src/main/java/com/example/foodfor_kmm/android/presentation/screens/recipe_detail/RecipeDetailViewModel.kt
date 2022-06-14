package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodfor_kmm.dataSource.repositories.RecipeService
import com.example.foodfor_kmm.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val recipeService: RecipeService,
) : ViewModel() {
    private val _recipe = mutableStateOf<Recipe?>(null)
    val recipe: State<Recipe?> = _recipe

    init {
        savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
            viewModelScope.launch {
                _recipe.value = recipeService.get(recipeId)
                println("KtorTest: ${recipe.value?.title}")
                println("KtorTest: ${recipe.value?.ingredients}")
            }
        }

    }


}