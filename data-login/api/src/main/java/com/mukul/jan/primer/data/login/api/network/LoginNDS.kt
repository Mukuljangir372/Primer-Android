package com.mukul.jan.primer.data.login.api.network

import kotlinx.coroutines.flow.Flow

interface LoginNDS {
    suspend fun signIn(key: String, password: String): Flow<String>
    suspend fun signUp(key: String, password: String): Flow<String>
    suspend fun isLoggedIn(): Flow<Boolean>
}