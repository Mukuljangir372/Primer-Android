package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAppUserDomain
import com.mukul.jan.primer.data.login.api.RealmAppApi
import com.mukul.jan.primer.data.login.api.RegisterUserApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterUserApiImpl @Inject constructor(
    private val realmAppApi: RealmAppApi,
    @RealmAppUserDomain private val userDomain: String,
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