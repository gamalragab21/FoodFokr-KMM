package com.example.foodfor_kmm.android.presentation.theme

import androidx.compose.runtime.Composable

// 1
typealias OnAddType = (List<String>) -> Unit
// 2
typealias onDismissType = () -> Unit
// 3
typealias composeFun = @Composable () -> Unit
// 4
typealias topBarFun = @Composable (Int) -> Unit
// 5
@Composable
fun emptyComposable() {
}