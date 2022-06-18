package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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

        when (painter.state) {
            is ImagePainter.State.Success -> {

            }
            is ImagePainter.State.Error -> {

                Image(painterResource(R.drawable.ic_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(RECIPE_IMAGE_HEIGHT.dp),
                    contentDescription = contentDescription)
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
                            .width(15.dp)
                            .wrapContentHeight(),
                    )
                }
            }
        }
    }


}