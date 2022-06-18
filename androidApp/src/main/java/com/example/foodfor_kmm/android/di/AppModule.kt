package com.example.foodfor_kmm.android.di

import android.content.Context
import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.common.utils.GenericMessageInfoQueueUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context,
    ) = context

    @Provides
    @Singleton
    @IODispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @Singleton
    fun provideDataTimeUtil():DataTimeUtil=DataTimeUtil()

    @Provides
    @Singleton
    fun provideGenericMessageInfoQueueUtil():GenericMessageInfoQueueUtil=GenericMessageInfoQueueUtil()

}