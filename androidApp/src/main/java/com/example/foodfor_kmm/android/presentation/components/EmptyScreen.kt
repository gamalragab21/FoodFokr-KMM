package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.foodfor_kmm.android.common.Constants

@Composable
fun EmptyScreen(
    emptyText: String = "No Data Found...",
    errorText: String = "",
) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = com.example.foodfor_kmm.android.R.drawable.ic_empty),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(Constants.RECIPE_IMAGE_HEIGHT.dp),
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        Text(
            text = emptyText,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary,
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        Text(
            text = errorText,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError,
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )

    }


}
