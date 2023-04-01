package com.mu.jan.primer.common

sealed interface Resource<T> {
    class Loading<T> : Resource<T>
    data class Success<T>(val msg: Message, val data: T) : Resource<T>
    class Failure<T>(val msg: Message, val data: T? = null) : Resource<T>
}