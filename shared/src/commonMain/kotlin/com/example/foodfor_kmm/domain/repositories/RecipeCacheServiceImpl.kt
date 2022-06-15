package com.example.foodfor_kmm.domain.repositories

import com.example.foodfor_kmm.common.Constants.RECIPE_PAGINATION_PAGE_SIZE
import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.dataSource.cache.*
import com.example.foodfor_kmm.dataSource.cache.repositories.RecipeCacheService
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodforkmm.dataSource.cache.RecipeDbQueries

class RecipeCacheServiceImpl(
    private val recipeDatabase: RecipeDatabase,
    private val dataTimeUtil: DataTimeUtil,
) : RecipeCacheService {
    private val queries: RecipeDbQueries = recipeDatabase.recipeDbQueries
    override fun insert(recipe: Recipe) {
        queries.insertRecipe(
            id = recipe.id.toLong(),
            title = recipe.title,
            publisher = recipe.publisher,
            featured_image = recipe.featuredImage,
            rating = recipe.rating.toLong(),
            source_url = recipe.sourceUrl,
            ingredients = recipe.ingredients.convertIngredientListToString(),
            date_updated = dataTimeUtil.toEpochMilliseconds(recipe.dataUpdated),
            date_added = dataTimeUtil.toEpochMilliseconds(recipe.dataAdded)
        )
    }

    override fun insert(recipe: List<Recipe>) {
        recipe.forEach {
            insert(it)
        }
    }

    override fun search(query: String, page: Int): List<Recipe> {
        return queries.searchRecipes(
            query = query,
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().map {
            Recipe(
                id = it.id.toInt(),
                title = it.title,
                publisher = it.publisher,
                featuredImage = it.featured_image,
                rating = it.rating.toInt(),
                sourceUrl = it.source_url,
                ingredients = it.ingredients.convertIngredientsToList(),
                dataAdded = dataTimeUtil.toLocalDate(it.date_added),
                dataUpdated = dataTimeUtil.toLocalDate(it.date_updated),
            )
        }
    }

    override fun getAll(page: Int): List<Recipe> {
        return queries.getAllRecipes(
            pageSize = RECIPE_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page - 1) * RECIPE_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toRecipeList(dataTimeUtil)
    }

    override fun getRecipeById(recipeId: Int): Recipe? {
//        return try {
            val recipe = queries.getRecipeById(id = recipeId.toLong())
                .executeAsOneOrNull()?.toRecipe(dataTimeUtil)
            println("RecipeData from repo: $recipe")
            return recipe
//        } catch (e: NullPointerException) {
//            println("RecipeData it's a null ")
//            null
//        }
    }

}