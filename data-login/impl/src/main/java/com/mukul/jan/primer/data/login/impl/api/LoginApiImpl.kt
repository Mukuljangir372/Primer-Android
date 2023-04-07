package com.mukul.jan.primer.data.login.impl.api

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAppUserDomain
import com.mukul.jan.primer.data.login.api.api.LoginApi
import com.mukul.jan.primer.data.login.api.api.RealmAppApi
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginApiImpl @Inject constructor(
    private val realmAppApi: RealmAppApi,
    @RealmAppUserDomain private val userDomain: String,
    private val dispatchers: AppCoroutineDispatcher,
) : LoginApi {
    @Throws
    override suspend fun signIn(key: String, password: String): String {
        return withContext(dispatchers.io) {
            realmAppApi.getApp()
                .login(Credentials.emailPassword(key + userDomain, password))
                .id
        }
    }

    @Throws
    override suspend fun signUp(key: String, password: String): String {
        return withContext(dispatchers.io) {
            realmAppApi.getApp()
                .emailPasswordAuth
                .registerUser(key + userDomain, password)
            key
        }
    }

    @Throws
    override suspend fun isLoggedIn(): Boolean {
        return withContext(dispatchers.io) {
            !realmAppApi.getApp().currentUser?.id.isNullOrEmpty()
        }
    }

}