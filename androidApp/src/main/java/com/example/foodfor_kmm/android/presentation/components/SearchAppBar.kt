package com.example.foodfor_kmm.android.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.foodfor_kmm.presentation.recipe_list.FoodCategory
import com.example.foodfor_kmm.presentation.recipe_list.FoodCategoryUtil

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchAppBar(
    query: String,
    categories: List<FoodCategory>,
    selectedCategory: FoodCategory? = null,
    onSelectCategoryChange: (FoodCategory) -> Unit,
    onQueryChange: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        elevation = 8.dp,
        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    value = query,
                    onValueChange = { onQueryChange(it) },
                    label = { Text(text = "Search") },

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onExecuteSearch()
                            keyboardController?.hide()
                        },
                    ),
                    leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                )
            }
            LazyRow(
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            ) {
                items(categories) {
                    FoodCategoryChip(category = it.value,
                        isSelected = selectedCategory == it,
                        onSelectedCategoryChange = {
                            FoodCategoryUtil().getFoodCategory(it)?.let { newFoodCategory ->
                                onSelectCategoryChange(newFoodCategory)
                            }
                        })
                }

            }
        }


    }

}