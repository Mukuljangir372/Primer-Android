package com.mukul.jan.primer.data.login.impl.api

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAuthApiQualifier
import com.mukul.jan.primer.data.login.api.api.AuthApi
import com.mukul.jan.primer.data.login.api.api.RealmAppApi
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.User
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Auth - necessary to making a universal app auth
 */
class AuthApiImpl @Inject constructor(
    @RealmAuthApiQualifier private val realmAuthApi: String,
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
