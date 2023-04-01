package com.mukul.jan.primer.data.login.api.network

import com.mukul.jan.primer.data.login.api.network.model.UserNetworkModel
import kotlinx.coroutines.flow.Flow

interface UserNDS {
    suspend fun getLoggedInUser(): Flow<UserNetworkModel>
    suspend fun getUser(id: String): Flow<UserNetworkModel>
    suspend fun insertOrUpdateUser(user: UserNetworkModel): Flow<UserNetworkModel>
}