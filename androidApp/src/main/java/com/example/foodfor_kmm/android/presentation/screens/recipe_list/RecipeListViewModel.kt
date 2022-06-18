package com.example.foodfor_kmm.android.presentation.screens.recipe_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodfor_kmm.common.utils.*
import com.example.foodfor_kmm.common.utils.Queue
import com.example.foodfor_kmm.domain.model.Recipe
import com.example.foodfor_kmm.interactos.recipe_list.SearchRecipeUseCase
import com.example.foodfor_kmm.presentation.recipe_list.FoodCategory
import com.example.foodfor_kmm.presentation.recipe_list.RecipeListEvent
import com.example.foodfor_kmm.presentation.recipe_list.RecipeListState
import com.example.foodfor_kmm.presentation.recipe_list_details.RecipeDetailsEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchRecipeUseCase: SearchRecipeUseCase,
    private val genericMessageInfoQueueUtil: GenericMessageInfoQueueUtil,

    ) : ViewModel() {

    private val _recipesSate = mutableStateOf(RecipeListState())
    val recipesSate: State<RecipeListState> = _recipesSate

    init {
        onTriggerEvent(RecipeListEvent.LoadRecipes)
        // EXAMPLE
        val messageInfoBuilder = GenericMessageInfo.Builder()
            .id(UUID.randomUUID().toString())
            .title("Kotlin multi platform")
            .uiComponentType(UIComponentType.Dialog)
            .description("First app Using KMM (Business logic and shared ui by compose ).")
            .positive(PositiveAction(
                positiveBtnTxt = "Cool",
                onPositiveAction = {
                    // do something special??
                    _recipesSate.value = _recipesSate.value.copy(query = "Kale")
                    onTriggerEvent(RecipeListEvent.ExecuteNewSearch)
                }
            ))
            .negative(NegativeAction(
                negativeBtnTxt = "Cancel",
                onNegativeAction = {
                    _recipesSate.value = _recipesSate.value.copy(query = "Cookies")
                    onTriggerEvent(RecipeListEvent.ExecuteNewSearch)
                }
            ))
        appendToMessageQueue(messageInfoBuilder)
    }

    private fun getRecipes() {
        searchRecipeUseCase.invoke(_recipesSate.value.page, _recipesSate.value.query)
            .onEach {
                println("RecipeListData: ${it.isLoading}")

                _recipesSate.value = _recipesSate.value.copy(isLoading = it.isLoading)
                it.data?.let {
                    appendRecipes(it)
                }
                it.message?.let {
                    appendToMessageQueue(it)
                }
            }.launchIn(viewModelScope)
    }

    fun onTriggerEvent(event: RecipeListEvent) {
        when (event) {
            is RecipeListEvent.LoadRecipes -> {
                getRecipes()
            }
            is RecipeListEvent.NextPage -> {
                nextPage()
            }
            is RecipeListEvent.OnQueryUpdate -> {
                if (event.query.isEmpty()) {
                    getRecipes()
                }
                _recipesSate.value =
                    _recipesSate.value.copy(query = event.query, selectedCategory = null)
            }
            is RecipeListEvent.OnSelectCategory -> {
                onSelectCategory(event.foodCategory)
            }
            is RecipeListEvent.ExecuteNewSearch -> {
                newSearch()
            }
            is RecipeListEvent.OnRemoveHeaderMessageFromQueue -> {
                removeHeadMessage()
            }
            else -> {
                val genericMessageInfo = GenericMessageInfo.Builder().id("RecipeListEvent Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.SnackBar)
                    .description("Invalid Request")

                appendToMessageQueue(genericMessageInfo)
            }
        }
    }

    private fun removeHeadMessage() {
        try {
            val queue = _recipesSate.value.queue
            queue.remove()
            _recipesSate.value = _recipesSate.value.copy(queue = Queue(mutableListOf()))

            _recipesSate.value = _recipesSate.value.copy(queue = queue)
        } catch (e: Exception) {
            //queue is empty
        }
    }

    private fun onSelectCategory(foodCategory: FoodCategory) {
        _recipesSate.value =
            _recipesSate.value.copy(query = foodCategory.value, selectedCategory = foodCategory)
        newSearch()
    }

    private fun newSearch() {
        _recipesSate.value = _recipesSate.value.copy(page = 1, recipes = emptyList())
        getRecipes()
    }


    private fun appendToMessageQueue(genericMessageInfo: GenericMessageInfo.Builder) {
        val queue = _recipesSate.value.queue

        if (!genericMessageInfoQueueUtil.doesMessageAlreadyExistInQueue(queue = queue,
                messageInfo = genericMessageInfo.build())
        ) {
            queue.add(genericMessageInfo.build())
            _recipesSate.value = _recipesSate.value.copy(queue = queue)
        }
    }

    private fun nextPage() {
        _recipesSate.value = _recipesSate.value.copy(page = _recipesSate.value.page + 1)
        getRecipes()
    }

    private fun appendRecipes(recipes: List<Recipe>) {
        val curr = ArrayList(_recipesSate.value.recipes)
        curr.addAll(recipes)
        _recipesSate.value = _recipesSate.value.copy(recipes = recipes)

    }
}