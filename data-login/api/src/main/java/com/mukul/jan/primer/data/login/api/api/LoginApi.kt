package com.mukul.jan.primer.data.login.api.api

interface LoginApi {
    @Throws
    suspend fun signIn(key: String, password: String): String

    @Throws
    suspend fun signUp(key: String, password: String): String

    @Throws
    suspend fun isLoggedIn(): Boolean
}