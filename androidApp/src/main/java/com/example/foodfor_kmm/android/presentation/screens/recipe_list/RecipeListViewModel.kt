package com.example.foodfor_kmm.android.presentation.screens.recipe_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodfor_kmm.common.DataState
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodfor_kmm.interactos.recipe_list.SearchRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchRecipeUseCase: SearchRecipeUseCase,
) : ViewModel() {

    private val _recipes = mutableStateOf<List<Recipe>>(emptyList())
    val recipes: State<List<Recipe>> = _recipes

    init {
        getRecipes()
    }
    private fun getRecipes() {
        searchRecipeUseCase.invoke(1, "chicken")
            .onEach {
                println("RecipeListData: ${it.isLoading}")

                it.data?.let {
                    it.forEach {
                        println("RecipeListData: ${it.id}")
                    }
                }
                it.message?.let {
                    println("RecipeListData: ${it}")
                }
            }.launchIn(viewModelScope)
    }


}