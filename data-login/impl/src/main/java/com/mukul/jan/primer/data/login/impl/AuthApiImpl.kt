package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.AuthApi
import com.mukul.jan.primer.data.login.api.RealmAppApi
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.User
import kotlinx.coroutines.withContext

/**
 * Auth - necessary to making a universal app auth
 */
class AuthApiImpl constructor(
    private val realmAuthApi: String,
    private val realmAppApi: RealmAppApi,
    private val dispatchers: AppCoroutineDispatcher,
) : AuthApi {
    @Throws
    override suspend fun auth(): User {
        return withContext(dispatchers.io) {
            realmAppApi.getApp().login(Credentials.apiKey(realmAuthApi))
        }
    }
}
