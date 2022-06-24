package com.example.foodfor_kmm.di

import com.example.foodfor_kmm.dataSource.network.KtorClientFactory
import com.example.foodfor_kmm.dataSource.repositories.RecipeService
import com.example.foodfor_kmm.domain.repositories.RecipeServiceImpl
import io.github.aakira.napier.Napier
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {
    single<RecipeService> {
        RecipeServiceImpl(get())
    }
    single {
        KtorClientFactory().build()
    }
}

fun initKoin(
    vararg othersModule: Module,
): KoinApplication = startKoin {
    try {
       // this.printLogger()
        val list = othersModule.toMutableList()
        list.add(appModule)
        modules(list.toList())
    }catch (e:Exception){
        Napier.e(e.message?:"", tag = "GAMALRAGAB")
    }
}