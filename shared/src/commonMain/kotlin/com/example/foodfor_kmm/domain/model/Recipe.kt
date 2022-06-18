package com.example.foodfor_kmm.domain.model

import kotlinx.datetime.LocalDateTime


data class Recipe(
    val id: Int,
    val title: String,
    val publisher:String,
    val featuredImage:String,
    val rating:Int,
    val sourceUrl:String,
    val ingredients:List<String> = listOf(),
    val dataAdded: LocalDateTime,
    val dataUpdated: LocalDateTime,

    ){
    override fun toString(): String {
        return "Recipe(id=$id, title='$title', publisher='$publisher', featuredImage='$featuredImage', rating=$rating, sourceUrl='$sourceUrl', ingredients=$ingredients, dataAdded=$dataAdded, dataUpdated=$dataUpdated)"
    }
}