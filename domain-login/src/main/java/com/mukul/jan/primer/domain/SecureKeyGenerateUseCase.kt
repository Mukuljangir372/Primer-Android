package com.mukul.jan.primer.domain

import com.mu.jan.primer.common.BaseUseCase
import com.mukul.jan.primer.data.login.api.repo.SecureKeyRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SecureKeyGenerateUseCase @Inject constructor(
    private val repo: SecureKeyRepo
) : BaseUseCase<SecureKeyGenerateUseCase.Params, Flow<String>>() {
    class Params

    override suspend fun doWork(params: Params): Flow<String> {
        return repo.generate()
    }
}