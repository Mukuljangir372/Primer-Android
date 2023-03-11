package com.mu.jan.primer.common

abstract class BaseUseCase<Params, Result> {
    abstract suspend fun doWork(params: Params): Result
    suspend operator fun invoke(params: Params): Result = doWork(params)
}