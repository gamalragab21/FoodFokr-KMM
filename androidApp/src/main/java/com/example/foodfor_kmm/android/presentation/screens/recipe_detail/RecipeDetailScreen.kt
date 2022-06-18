package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodfor_kmm.android.common.Constants.RECIPE_IMAGE_HEIGHT
import com.example.foodfor_kmm.android.presentation.components.EmptyScreen
import com.example.foodfor_kmm.android.presentation.components.RecipeCard
import com.example.foodfor_kmm.android.presentation.components.RecipeImage
import com.example.foodfor_kmm.android.presentation.components.shimmer.LoadingRecipeShimmer
import com.example.foodfor_kmm.android.presentation.theme.AppTheme
import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodfor_kmm.presentation.recipe_list_details.RecipeDetailsEvents
import com.example.foodfor_kmm.presentation.recipe_list_details.RecipeDetailsState

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun RecipeDetailScreen(
    state: RecipeDetailsState,
    dataTimeUtil: DataTimeUtil,
    onTriggerEvent: (RecipeDetailsEvents) -> Unit,
) {
    AppTheme(displayProgressBar = state.isLoading,
        dialogQueue = state.queue, onRemoveHeadFromQueue = {
            onTriggerEvent(RecipeDetailsEvents.OnRemoveHeaderMessageFromQueue)
        }) {
        if (state.recipe == null && state.isLoading) {
            LoadingRecipeShimmer(imageHeight = RECIPE_IMAGE_HEIGHT.dp)
        } else if (state.recipe == null) {
            Log.i("GAMALRAGAB", "RecipeDetailScreen: state is null")
            EmptyScreen(errorText ="We were unable to retrieve the details for this recipe.\nTry resetting the app." )
//            Text(
//                modifier = Modifier.padding(16.dp),
//                text = "We were unable to retrieve the details for this recipe.\nTry resetting the app.",
//                style = MaterialTheme.typography.body1,
//                color = MaterialTheme.colors.onError
//            )
        } else {
            RecipeView(recipe = state.recipe!!, dataTimeUtil = dataTimeUtil)
        }

    }

}