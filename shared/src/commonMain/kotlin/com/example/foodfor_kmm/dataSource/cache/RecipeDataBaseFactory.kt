package com.example.foodfor_kmm.dataSource.cache

import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodforkmm.dataSource.cache.Recipe_Entity
import com.squareup.sqldelight.db.SqlDriver

class RecipeDataBaseFactory constructor(
    private val driverFactory: DriverFactory,
) {
    fun createDataBase(): RecipeDatabase {
        return RecipeDatabase.invoke(driverFactory.createDriver())
    }

}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun Recipe_Entity.toRecipe(dataTimeUtil: DataTimeUtil): Recipe {
    return Recipe(
        id = id.toInt(),
        title = title,
        publisher = publisher,
        featuredImage = featured_image,
        rating = rating.toInt(),
        sourceUrl = source_url,
        ingredients = ingredients.convertIngredientsToList(),
        dataAdded = dataTimeUtil.toLocalDate(date_added),
        dataUpdated = dataTimeUtil.toLocalDate(date_updated),
    )
}

fun List<Recipe_Entity>.toRecipeList(dataTimeUtil: DataTimeUtil) = map {
    it.toRecipe(dataTimeUtil)
}

/**
 * carrot,potato,chicken,...
 */

fun List<String>.convertIngredientListToString(): String {
    val ingredientsString = StringBuilder()
    forEach { ingredient ->
        ingredientsString.append("$ingredient,")
    }
    return ingredientsString.toString()
}

fun String.convertIngredientsToList(): List<String> {
    val list: ArrayList<String> = ArrayList()
    for (ingredient in split(",")) {
        list.add(ingredient)
    }
    return list
}

