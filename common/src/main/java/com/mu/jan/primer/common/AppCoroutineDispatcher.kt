package com.mu.jan.primer.common

import kotlinx.coroutines.CoroutineDispatcher

data class AppCoroutineDispatcher(
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher
)