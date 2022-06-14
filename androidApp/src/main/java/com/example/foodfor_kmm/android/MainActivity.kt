package com.example.foodfor_kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.foodfor_kmm.android.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalStdlibApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    @IODispatcher
//    @Inject
//    lateinit var ioDispatcher: CoroutineDispatcher
//   private val recipeId = 1551

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        val ktorClient = KtorClientFactory().build()
//        CoroutineScope(ioDispatcher).launch {
//            val recipeService = RecipeServiceImpl(ktorClient)
//            val recipe = recipeService.get(recipeId)
//            println("KtorTest: ${recipe.title}")
//            println("KtorTest: ${recipe.ingredients}")
////            println("KtorTest: ${DataTimeUtil().humanizeDatetime(recipe.dataUpdated)}")
//        }
        setContent {
            Navigation()
        }
    }
}
