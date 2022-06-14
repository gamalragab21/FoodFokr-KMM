package com.example.foodfor_kmm.dataSource.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class RecipeSearchResponse(
    @SerialName("count")
    var count: Int,

    @SerialName("next")
    var next: String,

    @SerialName("previous")
    var previous: String,

    @SerialName("results")
    var results: List<RecipeDto>,
)