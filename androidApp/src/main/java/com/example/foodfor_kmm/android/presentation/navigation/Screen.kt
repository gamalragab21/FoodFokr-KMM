package com.example.foodfor_kmm.android.presentation.navigation

sealed class Screen(val route: String) {

    object RecipeListScreen : Screen("recipe_list")
    object RecipeDetailScreen : Screen("recipe_detail")

    fun withArgs(vararg args: String): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}

