package com.example.foodfor_kmm.dataSource.network.repositories

import com.example.foodfor_kmm.domain.model.Recipe

interface RecipeService {


    suspend fun search(
        page: Int,
        query: String,
    ): List<Recipe>

    suspend fun get(
        id: Int
    ): Recipe}