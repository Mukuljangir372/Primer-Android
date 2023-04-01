package com.mukul.jan.primer.data.login.api.repo

import com.mukul.jan.primer.data.login.api.repo.model.RegisterUserActionDataModel
import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import kotlinx.coroutines.flow.Flow

interface LoginRepo {
    suspend fun signIn(key: String, password: String): Flow<String>
    suspend fun register(model: RegisterUserActionDataModel): Flow<UserModel>
    suspend fun isLoggedIn(): Flow<Boolean>
}