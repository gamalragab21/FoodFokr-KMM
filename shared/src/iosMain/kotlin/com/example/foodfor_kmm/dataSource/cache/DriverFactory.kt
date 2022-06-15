package com.example.foodfor_kmm.dataSource.cache

import com.example.foodfor_kmm.datasource.cache.RecipeDatabase
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory() {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(RecipeDatabase.Schema, "recipes.db")
    }
}