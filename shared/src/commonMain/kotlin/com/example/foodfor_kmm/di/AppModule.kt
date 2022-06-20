package com.example.foodfor_kmm.di

import com.example.foodfor_kmm.common.utils.DataTimeUtil
import com.example.foodfor_kmm.common.utils.GenericMessageInfoQueueUtil
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule = module {

    single {
        DataTimeUtil()
    }
    single {
        GenericMessageInfoQueueUtil()
    }
}


fun initKoin(
    otherModule: Module = module { },
): KoinApplication = startKoin {
    modules(appModule,otherModule)
}