package com.mukul.jan.primer.data.login.api.repo

import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepo {
    suspend fun getLoggedInUser(): Flow<UserModel>
    suspend fun getUser(id: String): Flow<UserModel>
    suspend fun insertOrUpdateUser(user: UserModel): Flow<UserModel>
}