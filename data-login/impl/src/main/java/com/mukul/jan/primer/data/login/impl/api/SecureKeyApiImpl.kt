package com.mukul.jan.primer.data.login.impl.api

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.api.SecureKeyApi
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class SecureKeyApiImpl @Inject constructor(
    private val dispatchers: AppCoroutineDispatcher
) : SecureKeyApi {
    override suspend fun generate(): String {
        return withContext(dispatchers.io) {
            "0x1" + UUID.randomUUID()
                .toString()
                .replace("-", "0")
                .substring(0, 15)
        }
    }
}