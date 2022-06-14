package com.example.foodfor_kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.foodfor_kmm.android.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalStdlibApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}
