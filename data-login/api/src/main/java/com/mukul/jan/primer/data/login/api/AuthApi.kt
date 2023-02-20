package com.mukul.jan.primer.data.login.api

import io.realm.kotlin.mongodb.User

interface AuthApi {
    @Throws
    suspend fun auth(): User
}



