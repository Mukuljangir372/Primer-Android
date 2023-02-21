package com.mukul.jan.primer.data.login.api

interface RegisterUserApi {
    @Throws
    suspend fun register(key: String, password: String)
}