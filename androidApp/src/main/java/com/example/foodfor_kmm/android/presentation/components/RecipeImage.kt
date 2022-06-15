package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.foodfor_kmm.android.R
import com.example.foodfor_kmm.android.common.Constants.RECIPE_IMAGE_HEIGHT

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RecipeImage(
    url: String,
    contentDescription: String = "image",
) {
    val painter = rememberImagePainter(url)

    Box {
        Image(painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxWidth()
                .height(RECIPE_IMAGE_HEIGHT.dp),
            contentScale = ContentScale.Crop)
    }

    when (painter.state) {
        is ImagePainter.State.Error -> {
            println("RecipeData Loading Error for recipe image ")

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(RECIPE_IMAGE_HEIGHT.dp),
            ) {
                Image(painterResource(R.drawable.ic_image),
                    contentScale = ContentScale.Crop,
                    contentDescription = contentDescription)
            }
        }
        is ImagePainter.State.Loading -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(RECIPE_IMAGE_HEIGHT.dp),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)
                )
            }
        }
        is ImagePainter.State.Success -> {
            println("RecipeData Loading success for recipe image ")

        }
    }

}