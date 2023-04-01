package com.mukul.jan.primer.data.login.api.repo

import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    suspend fun signIn(key: String, password: String): Flow<String>
    suspend fun signUp(key: String, password: String): Flow<String>
    suspend fun isLoggedIn(): Flow<Boolean>
}