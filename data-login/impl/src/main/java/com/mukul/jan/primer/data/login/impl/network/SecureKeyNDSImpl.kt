package com.mukul.jan.primer.data.login.impl.network

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.channelFlowWithTimeout
import com.mukul.jan.primer.data.login.api.api.SecureKeyApi
import com.mukul.jan.primer.data.login.api.network.SecureKeyNDS
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SecureKeyNDSImpl @Inject constructor(
    private val api: SecureKeyApi,
    private val dispatcher: AppCoroutineDispatcher,
) : SecureKeyNDS {
    override suspend fun generate(): Flow<String> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            send(api.generate())
        }
    }
}