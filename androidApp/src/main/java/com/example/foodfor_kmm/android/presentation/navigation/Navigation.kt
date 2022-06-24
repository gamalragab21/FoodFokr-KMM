package com.example.foodfor_kmm.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.foodfor_kmm.android.presentation.screens.recipe_detail.RecipeDetailScreen
import com.example.foodfor_kmm.android.presentation.screens.recipe_detail.RecipeDetailViewModel
import com.example.foodfor_kmm.android.presentation.screens.recipe_list.RecipeListScreen
import com.example.foodfor_kmm.android.presentation.screens.recipe_list.RecipeListViewModel
import io.ktor.http.*
import org.koin.androidx.compose.getStateViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.RecipeListScreen.route) {

        // TODO: mainScreen
        composable(route = Screen.RecipeListScreen.route) { navBackStackEntry ->
            val viewModel: RecipeListViewModel by viewModel { parametersOf(navBackStackEntry.savedStateHandle) }
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
            val viewModel: RecipeDetailViewModel by viewModel { parametersOf(navBackStackEntry.arguments) }
            RecipeDetailScreen(recipe = viewModel.recipe.value)
        }
    }
}
