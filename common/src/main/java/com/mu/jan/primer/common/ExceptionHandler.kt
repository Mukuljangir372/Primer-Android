package com.mu.jan.primer.common

interface ExceptionHandler {
    fun toReadable(throwable: Throwable?): String
    fun toReadableException(throwable: Throwable?): Exception
}