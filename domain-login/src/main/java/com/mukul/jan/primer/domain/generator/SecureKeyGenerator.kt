package com.mukul.jan.primer.domain.generator

import com.mukul.jan.primer.data.login.api.SecureKeyApi
import javax.inject.Inject

interface SecureKeyGenerator {
    suspend fun generate(): String
}

class SecureKeyGeneratorImpl @Inject constructor(
    private val api: SecureKeyApi
) : SecureKeyGenerator {
    override suspend fun generate(): String {
        return api.generate()
    }
}