package com.mukul.jan.primer.data.login.impl.network

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.channelFlowWithTimeout
import com.mukul.jan.primer.data.login.api.api.LoginApi
import com.mukul.jan.primer.data.login.api.network.LoginNDS
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginNDSImpl @Inject constructor(
    private val loginApi: LoginApi,
    private val dispatcher: AppCoroutineDispatcher,
) : LoginNDS {
    @Throws
    override suspend fun signIn(key: String, password: String): Flow<String> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            send(loginApi.signIn(key = key, password = password))
        }
    }

    @Throws
    override suspend fun signUp(key: String, password: String): Flow<String> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            send(loginApi.signUp(key = key, password = password))
        }
    }

    @Throws
    override suspend fun isLoggedIn(): Flow<Boolean> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            send(loginApi.isLoggedIn())
        }
    }
}