package com.mukul.jan.primer.data.login.api

interface LoginUserApi {
    //returns logged in user id
    suspend fun login(key: String, password: String): String
}