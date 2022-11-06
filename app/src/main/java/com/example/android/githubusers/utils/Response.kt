package com.example.android.githubusers.utils

sealed class Response<T> {

    class Loading<T> : Response<T>()
    class Cancel<T> : Response<T>()
    data class Success<T>(val data: T) : Response<T>()
    data class Error<T>(val e: Throwable) : Response<T>()
    class SuccessWithoutData<T> : Response<T>()

    companion object {
        fun <T> loading(): Response<T> = Loading()
        fun <T> cancel(): Response<T> = Cancel()
        fun <T> success(data: T): Response<T> = Success(data)
        fun <T> error(e: Throwable): Response<T> = Error(e)
        fun <T> successWithoutData(): Response<T> = SuccessWithoutData()
    }

    val isLoading: Boolean get() = this is Loading

    val isSuccess: Boolean get() = this is Success

    val isFailure: Boolean get() = this is Error

    fun getDataIfSuccess(): T? {
        return if (this is Success) this.data else null
    }
}
