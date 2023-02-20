package com.mukul.jan.primer.data.login.api

interface LoginUserApi {
    fun login(key: String, password: String)
}