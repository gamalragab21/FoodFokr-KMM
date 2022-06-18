package com.example.foodfor_kmm.common

import com.example.foodfor_kmm.common.utils.GenericMessageInfo

data class DataState<T>(
    val message: GenericMessageInfo.Builder? = null,
    val data: T? = null,
    val isLoading: Boolean = false,
) {
    companion object {
        fun <T> error(
            message: GenericMessageInfo.Builder,
        ): DataState<T> = DataState(message)

        fun <T> data(
            message: GenericMessageInfo.Builder? = null,
            data: T? = null,
        ): DataState<T> = DataState(message = message, data = data)

        fun <T> loading(
            loading: Boolean = false,
        ): DataState<T> = DataState(isLoading = loading)
    }
}