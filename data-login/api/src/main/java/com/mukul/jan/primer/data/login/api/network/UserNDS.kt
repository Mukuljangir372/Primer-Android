package com.mukul.jan.primer.data.login.api.network

import com.mukul.jan.primer.data.login.api.network.model.UserNetworkModel
import kotlinx.coroutines.flow.Flow

interface UserNDS {
    @Throws
    suspend fun getLoggedInUser(): Flow<UserNetworkModel>

    @Throws
    suspend fun getUser(id: String): Flow<UserNetworkModel>

    @Throws
    suspend fun insertOrUpdateUser(user: UserNetworkModel): Flow<UserNetworkModel>
}