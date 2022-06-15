package com.example.foodfor_kmm.android.di

import android.content.Context
import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.dataSource.cache.DriverFactory
import com.example.foodfor_kmm.dataSource.cache.RecipeDataBaseFactory
import com.example.foodfor_kmm.dataSource.cache.RecipeDatabase
import com.example.foodfor_kmm.dataSource.cache.repositories.RecipeCacheService
import com.example.foodfor_kmm.domain.repositories.RecipeCacheServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDriverFactory(@ApplicationContext context: Context):DriverFactory=
        DriverFactory(context)

    @Singleton
    @Provides
    fun provideRecipeDataBase(
        driverFactory: DriverFactory
    ):RecipeDatabase= RecipeDataBaseFactory(driverFactory).createDataBase()

    @Singleton
    @Provides
    fun provideRecipeCacheRecipe(
        recipeDatabase: RecipeDatabase,
        dataTimeUtil:DataTimeUtil
    ):RecipeCacheService= RecipeCacheServiceImpl(recipeDatabase,dataTimeUtil)
}