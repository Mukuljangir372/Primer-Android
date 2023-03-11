package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.RealmAppApi
import com.mukul.jan.primer.data.login.api.RegisterUserApi
import kotlinx.coroutines.withContext

class RegisterUserApiImpl constructor(
    private val realmAppApi: RealmAppApi,
    private val userDomain: String,
    private val dispatchers: AppCoroutineDispatcher,
) : RegisterUserApi {
    @Throws
    override suspend fun register(key: String, password: String) {
        return withContext(dispatchers.io) {
            realmAppApi.getApp()
                .emailPasswordAuth
                .registerUser(key + userDomain, password)
        }
    }
}