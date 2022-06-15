package com.example.foodfor_kmm.dataSource.cache

import android.content.Context
import com.example.foodfor_kmm.datasource.cache.RecipeDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory constructor(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(RecipeDatabase.Schema, context, "recipes.db")
    }
}