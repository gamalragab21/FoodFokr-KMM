package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodfor_kmm.domain.model.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    onRecipeItemClicked: (Recipe) -> Unit,
) {


    Box {

        Card(shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(
                    vertical = 6.dp
                )
                .fillMaxWidth()
                .clickable { onRecipeItemClicked(recipe) },
            elevation = 8.dp
        ) {

            Column {
                RecipeImage(url = recipe.featuredImage, contentDescription = recipe.title)

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = recipe.title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h3)

                    Text(text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h5)
                }


            }

        }


    }


}