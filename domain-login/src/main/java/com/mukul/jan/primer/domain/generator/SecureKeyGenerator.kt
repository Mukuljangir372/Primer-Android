package com.mukul.jan.primer.domain.generator

import com.mukul.jan.primer.data.login.api.SecureKeyApi

interface SecureKeyGenerator {
    suspend fun generate(): String
}

class SecureKeyGeneratorImpl constructor(
    private val api: SecureKeyApi
) : SecureKeyGenerator {
    override suspend fun generate(): String {
        return api.generate()
    }
}