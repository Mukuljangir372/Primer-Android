package com.mukul.jan.primer.data.login.api.repo.model

data class RegisterUserActionDataModel(
    val username: String,
    val password: String,
    val privateKey: String,
    val publicKey: String,
)