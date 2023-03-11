package com.mukul.jan.primer.data.login.api

import com.mukul.jan.primer.data.login.api.model.UserRealmModel

interface UserApi {
    @Throws
    suspend fun getLoggedInUser(): UserRealmModel

    @Throws
    suspend fun getUser(id: String): UserRealmModel

    @Throws
    suspend fun insertOrUpdateUser(model: UserRealmModel)
}