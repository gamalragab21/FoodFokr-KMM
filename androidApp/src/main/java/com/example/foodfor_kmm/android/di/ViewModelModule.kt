package com.example.foodfor_kmm.android.di

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.example.foodfor_kmm.android.presentation.screens.recipe_detail.RecipeDetailViewModel
import com.example.foodfor_kmm.android.presentation.screens.recipe_list.RecipeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelMode= module {
    viewModel { (savedStateHandle:Bundle)  ->
          RecipeListViewModel(savedStateHandle)
    }
    viewModel { (savedStateHandle:Bundle)  ->
        RecipeDetailViewModel(savedStateHandle,get())
    }
}