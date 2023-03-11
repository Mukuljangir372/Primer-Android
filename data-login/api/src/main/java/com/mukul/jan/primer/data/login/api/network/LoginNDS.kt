package com.mukul.jan.primer.data.login.api.network

interface LoginNDS {
    fun signIn()
    fun signUp()
    fun isLoggedIn(): Boolean
}