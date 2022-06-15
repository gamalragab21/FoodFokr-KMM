package com.example.foodfor_kmm.android.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.foodfor_kmm.android.presentation.theme.*

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    displayProgressBar: Boolean,
    content: @Composable () -> Unit,
) {
// TODO: Add Colors
    val colors = if (darkTheme) {
        darkColors()
            .copy(
                primary = primaryDarkColor,
                primaryVariant = primaryLightColor,
                secondary = secondaryDarkColor,
                secondaryVariant = secondaryLightColor,
                onPrimary = Color.White,
            )
    } else {
        lightColors()
            .copy(
                primary = primaryColor,
                primaryVariant = primaryLightColor,
                secondary = secondaryColor,
                secondaryVariant = secondaryLightColor,
                onPrimary = Color.Black,
            )
    }
// TODO: Add Theme
    MaterialTheme(
        colors = colors,
        typography = QuickSandTypography,
        shapes = AppShapes
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color =Grey1)
        ){
            content()
            if(displayProgressBar){
                // TODO("Show indeterminate progress bar")
            }
        }
    }
}