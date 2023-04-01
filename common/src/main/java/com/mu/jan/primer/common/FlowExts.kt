package com.mu.jan.primer.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.withTimeout

fun <E> channelFlowWithTimeout(
    dispatcher: CoroutineDispatcher,
    timeout: Long = 3000,
    retryAttempt: Int = 3,
    block: suspend ProducerScope<E>.() -> Unit,
) = channelFlow {
    withTimeout(timeout) {
        block.invoke(this@channelFlow)
    }
}.flowOn(dispatcher).retryWhen { cause, attempt ->
    if (cause is TimeoutCancellationException && attempt < retryAttempt) {
        delay(2000)
        true
    } else false
}