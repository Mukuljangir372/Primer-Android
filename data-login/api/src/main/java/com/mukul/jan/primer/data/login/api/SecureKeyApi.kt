package com.mukul.jan.primer.data.login.api

interface SecureKeyApi {
    suspend fun generate(): String
}