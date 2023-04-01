package com.mukul.jan.primer.data.login.api.api

interface SecureKeyApi {
    suspend fun generate(): String
}