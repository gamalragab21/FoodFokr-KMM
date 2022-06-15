package com.example.foodfor_kmm.dataSource.cache.repositories

import com.example.foodfor_kmm.domain.model.Recipe

interface RecipeCacheService {
    fun insert(recipe: Recipe)

    fun insert(recipe: List<Recipe>)

    fun search(query:String, page:Int):List<Recipe>


    fun getAll(page: Int):List<Recipe>

    @Throws(NullPointerException::class)
    fun getRecipeById(recipeId: Int):Recipe?

}