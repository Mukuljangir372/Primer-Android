package com.mukul.jan.primer.data.login.impl.repo

import com.mukul.jan.primer.data.login.api.network.LoginNDS
import com.mukul.jan.primer.data.login.api.repo.LoginRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepoImpl @Inject constructor(
    private val nds: LoginNDS
) : LoginRepo {
    override suspend fun signIn(key: String, password: String): Flow<String> {
        return flow {

        }
    }

    override suspend fun signUp(key: String, password: String): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun isLoggedIn(): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}