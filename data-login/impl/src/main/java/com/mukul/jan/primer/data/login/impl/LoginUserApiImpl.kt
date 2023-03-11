package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.LoginUserApi
import com.mukul.jan.primer.data.login.api.RealmAppApi
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.withContext

class LoginUserApiImpl constructor(
    private val realmAppApi: RealmAppApi,
    private val userDomain: String,
    private val dispatchers: AppCoroutineDispatcher,
) : LoginUserApi {
    @Throws
    override suspend fun login(key: String, password: String): String {
        return withContext(dispatchers.io) {
            realmAppApi.getApp()
                .login(Credentials.emailPassword(key + userDomain, password))
                .id
        }
    }
}