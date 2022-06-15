package com.example.foodfor_kmm.dataSource.cache

import com.squareup.sqldelight.db.SqlDriver

class RecipeDataBaseFactory constructor(
    private val driverFactory: DriverFactory,
) {
    fun createDataBase():RecipeDatabase{
        return RecipeDatabase.invoke(driverFactory.createDriver())
    }

}

expect class DriverFactory{
    fun createDriver():SqlDriver
}