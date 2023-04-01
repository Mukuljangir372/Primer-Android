package com.mukul.jan.primer.data.login.api.repo

import kotlinx.coroutines.flow.Flow

interface SecureKeyRepo {
    suspend fun generate(): Flow<String>
}