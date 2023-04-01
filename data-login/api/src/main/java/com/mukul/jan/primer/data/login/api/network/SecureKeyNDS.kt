package com.mukul.jan.primer.data.login.api.network

import kotlinx.coroutines.flow.Flow

interface SecureKeyNDS {
    suspend fun generate(): Flow<String>
}