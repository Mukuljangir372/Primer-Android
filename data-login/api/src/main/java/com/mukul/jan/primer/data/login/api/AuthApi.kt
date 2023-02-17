package com.mukul.jan.primer.data.login.api

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAuthApiQualifier
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.User
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface AuthApi {
    suspend fun auth(): User
}

class AuthApiImpl @Inject constructor(
    @RealmAuthApiQualifier private val realmAuthApi: String,
    private val realmAppApi: RealmAppApi,
    private val dispatchers: AppCoroutineDispatcher,
) : AuthApi {

    @Throws
    override suspend fun auth(): User {
        return withContext(dispatchers.io) {
            realmAppApi.getApp()
                .login(Credentials.apiKey(realmAuthApi))
        }
    }
}


