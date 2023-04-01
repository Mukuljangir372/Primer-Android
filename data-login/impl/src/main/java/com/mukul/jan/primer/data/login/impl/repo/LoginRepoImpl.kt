package com.mukul.jan.primer.data.login.impl.repo

import com.mukul.jan.primer.data.login.api.network.LoginNDS
import com.mukul.jan.primer.data.login.api.repo.LoginRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepoImpl @Inject constructor(
    private val nds: LoginNDS
) : LoginRepo {
    override suspend fun signIn(key: String, password: String): Flow<String> {
        return nds.signIn(key = key, password = password)
    }

    override suspend fun signUp(key: String, password: String): Flow<String> {
        return nds.signUp(key = key, password = password)
    }

    override suspend fun isLoggedIn(): Flow<Boolean> {
        return nds.isLoggedIn()
    }
}