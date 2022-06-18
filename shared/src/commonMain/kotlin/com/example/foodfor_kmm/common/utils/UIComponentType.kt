package com.example.foodfor_kmm.common.utils

sealed class UIComponentType {
    object Dialog:UIComponentType()
    object SnackBar:UIComponentType()
    object None:UIComponentType()
}