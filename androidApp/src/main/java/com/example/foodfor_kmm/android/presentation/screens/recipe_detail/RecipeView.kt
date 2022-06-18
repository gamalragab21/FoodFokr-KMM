package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodfor_kmm.android.presentation.components.RecipeImage
import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.domain.model.Recipe


@Composable
fun RecipeView(
    recipe: Recipe,
    dataTimeUtil: DataTimeUtil
){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            RecipeImage(
                url = recipe.featuredImage,
                contentDescription = recipe.title
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                ){
                    Text(
                        text = recipe.title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start)
                        ,
                        style = MaterialTheme.typography.h3
                    )
                    val rank = recipe.rating.toString()
                    Text(
                        text = rank,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically)
                        ,
                        style = MaterialTheme.typography.h5
                    )
                }
                val datetimeUtil = remember{dataTimeUtil}
                Text(
                    text = "Updated ${datetimeUtil.humanizeDatetime(recipe.dataAdded)} by ${recipe.publisher}"
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                    ,
                    style = MaterialTheme.typography.caption
                )
                for(ingredient in recipe.ingredients){
                    Text(
                        text = ingredient,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
                        ,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}