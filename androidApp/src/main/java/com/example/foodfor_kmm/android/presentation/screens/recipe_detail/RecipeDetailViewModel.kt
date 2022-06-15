package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodfor_kmm.interactos.recipe_detail.RecipeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val recipeDetailUseCase: RecipeDetailUseCase,
) : ViewModel() {
    private val _recipe = mutableStateOf<Recipe?>(null)
    val recipe: State<Recipe?> = _recipe

    init {
        savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
            getRecipeDetails(recipeId)
        }
    }

    private fun getRecipeDetails(id: Int) {
        recipeDetailUseCase.invoke(id)
            .onEach {
                println("RecipeData: ${it.isLoading}")
                it.data.let {
                    println("RecipeData: ${it}")
                    _recipe.value=it
                }
                it.message?.let {
                    println("RecipeData: ${it}")
                }
            }.launchIn(viewModelScope)
    }


}