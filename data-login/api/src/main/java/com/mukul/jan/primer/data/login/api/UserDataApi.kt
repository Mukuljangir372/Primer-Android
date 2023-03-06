package com.mukul.jan.primer.data.login.api

interface UserDataApi {
    data class Save(
        val username: String,
        val userKey: String,
    )

    suspend fun save(userId: String, save: Save)
}