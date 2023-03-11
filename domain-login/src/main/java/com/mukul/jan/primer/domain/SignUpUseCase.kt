package com.mukul.jan.primer.domain

import com.mu.jan.primer.common.BaseUseCase
import com.mu.jan.primer.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor() :
    BaseUseCase<SignUpUseCase.Params, Flow<Resource<SignUpUseCase.Result>>>() {
    data class Params(
        val username: String,
        val password: String,
        val privateKey: String,
        val publicKey: String,
    )

    class Result

    override suspend fun doWork(params: Params): Flow<Resource<Result>> {
        return flow {

        }
    }
}