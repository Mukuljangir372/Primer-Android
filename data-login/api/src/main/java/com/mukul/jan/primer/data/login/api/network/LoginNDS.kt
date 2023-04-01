package com.mukul.jan.primer.data.login.api.network

import kotlinx.coroutines.flow.Flow

interface LoginNDS {
    @Throws
    suspend fun signIn(key: String, password: String): Flow<String>

    @Throws
    suspend fun signUp(key: String, password: String): Flow<String>

    @Throws
    suspend fun isLoggedIn(): Flow<Boolean>
}