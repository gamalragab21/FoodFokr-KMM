package com.example.foodfor_kmm.android.presentation.screens.recipe_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodfor_kmm.common.utils.*
import com.example.foodfor_kmm.interactos.recipe_detail.RecipeDetailUseCase
import com.example.foodfor_kmm.presentation.recipe_list_details.RecipeDetailsEvents
import com.example.foodfor_kmm.presentation.recipe_list_details.RecipeDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val recipeDetailUseCase: RecipeDetailUseCase,
    val dataTimeUtil: DataTimeUtil,
   private val genericMessageInfoQueueUtil: GenericMessageInfoQueueUtil,
) : ViewModel() {
    private val _recipeSate = mutableStateOf(RecipeDetailsState())
    val recipeSate: State<RecipeDetailsState> = _recipeSate

    init {
        savedStateHandle.get<Int>("recipeId")?.let { recipeId ->
            onTriggerEvent(RecipeDetailsEvents.GetRecipe(recipeId))
        }
    }

    fun onTriggerEvent(event: RecipeDetailsEvents) {
        when (event) {
            is RecipeDetailsEvents.GetRecipe -> {
                getRecipeDetails(event.recipeId)
            }
            is RecipeDetailsEvents.OnRemoveHeaderMessageFromQueue->{
                removeHeadMessage()
            }
            else -> {
                val genericMessageInfo = GenericMessageInfo.Builder().id("RecipeDetailsEvent Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.SnackBar)
                    .description("Invalid Request")
                appendToMessageQueue(genericMessageInfo)
            }
        }
    }

    private fun appendToMessageQueue(genericMessageInfo: GenericMessageInfo.Builder) {
        val queue = _recipeSate.value.queue

        if (!genericMessageInfoQueueUtil.doesMessageAlreadyExistInQueue(queue = queue, messageInfo = genericMessageInfo.build())) {
            queue.add(genericMessageInfo.build())
            _recipeSate.value = _recipeSate.value.copy(queue = queue)
        }
    }


    private fun removeHeadMessage() {
        try {
            val queue=_recipeSate.value.queue
            queue.remove()
            _recipeSate.value=_recipeSate.value.copy(queue= Queue(mutableListOf()))

            _recipeSate.value=_recipeSate.value.copy(queue=queue)
        }catch (e:Exception){
            //queue is empty
        }
    }
    private fun getRecipeDetails(id: Int) {
        recipeDetailUseCase.invoke(id)
            .onEach {
                _recipeSate.value = _recipeSate.value.copy(isLoading = it.isLoading)
                it.data?.let {
                    _recipeSate.value = _recipeSate.value.copy(recipe = it)
                }
                it.message?.let {
                    appendToMessageQueue(it)
                }
            }.launchIn(viewModelScope)
    }


}