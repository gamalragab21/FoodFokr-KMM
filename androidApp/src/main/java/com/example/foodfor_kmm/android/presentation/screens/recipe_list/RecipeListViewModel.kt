package com.example.foodfor_kmm.android.presentation.screens.recipe_list

import android.os.Bundle
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class RecipeListViewModel  constructor(
    private val savedStateHandle: Bundle,
) : ViewModel() {

    init {
        println("GAMALRAGAB RecipeListViewModel is injected")
    }


}