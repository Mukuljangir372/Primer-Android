package com.mukul.jan.primer.data.login.api

interface KeyApi {
    suspend fun generate(): String
}