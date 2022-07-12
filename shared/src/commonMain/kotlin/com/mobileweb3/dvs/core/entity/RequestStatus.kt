package com.mobileweb3.dvs.core.entity

sealed class RequestStatus<T> {
    data class Error<T>(val description: Throwable) : RequestStatus<T>()

    class Loading<T> : RequestStatus<T>()

    data class Data<T>(val data: T, override val isRefreshing: Boolean = false) : RequestStatus<T>() {

        override fun refresh() = Data(data, true)
    }

    val isLoading: Boolean get() = this is Loading

    open val isRefreshing: Boolean = false

    val isError: Boolean get() = this is Error

    val dataOrNull: T? get() = (this as? Data)?.data

    open fun refresh(): RequestStatus<T> = Loading<T>()
}