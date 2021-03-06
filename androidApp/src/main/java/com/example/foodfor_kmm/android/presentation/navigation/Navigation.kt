package com.example.foodfor_kmm.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.foodfor_kmm.android.presentation.screens.recipe_detail.RecipeDetailScreen
import com.example.foodfor_kmm.android.presentation.screens.recipe_detail.RecipeDetailViewModel
import com.example.foodfor_kmm.android.presentation.screens.recipe_list.RecipeListScreen
import org.koin.androidx.compose.viewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.RecipeListScreen.route) {

        // TODO: mainScreen
        composable(route = Screen.RecipeListScreen.route) {
            RecipeListScreen() { recipeId ->
                navController.navigate(Screen.RecipeDetailScreen.withArgs(recipeId.toString()))
            }
        }

        // TODO: SecondScreen
        composable(
            route = Screen.RecipeDetailScreen.route + "/{recipeId}",
            arguments = listOf(
                navArgument("recipeId") {
                    this.nullable = false
                    this.type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel: RecipeDetailViewModel =
                viewModel(key = "RecipeDetailViewModel", factory = factory)
            //  RecipeDetailScreen(recipeId = navBackStackEntry.arguments?.getInt("recipeId"))
            RecipeDetailScreen(recipe = viewModel.recipe.value)
        }
    }
}