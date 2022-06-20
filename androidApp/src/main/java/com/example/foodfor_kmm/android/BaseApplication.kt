package com.example.foodfor_kmm.android

import android.app.Application
import com.example.foodfor_kmm.di.initKoin
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}