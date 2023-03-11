package com.mukul.jan.primer.data.login.api.repo

interface LoginRepo {
    fun isLoggedIn()
    fun signIn()
    fun signUp()
}