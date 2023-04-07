package com.mukul.jan.primer.data.login.impl.repo

import com.mukul.jan.primer.data.login.api.mapper.toUserModel
import com.mukul.jan.primer.data.login.api.mapper.toUserNetworkModel
import com.mukul.jan.primer.data.login.api.network.LoginNDS
import com.mukul.jan.primer.data.login.api.network.UserNDS
import com.mukul.jan.primer.data.login.api.repo.LoginRepo
import com.mukul.jan.primer.data.login.api.repo.model.RegisterUserActionDataModel
import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(FlowPreview::class)
class LoginRepoImpl @Inject constructor(
    private val loginNDS: LoginNDS,
    private val userNDS: UserNDS,
) : LoginRepo {
    override suspend fun signIn(key: String, password: String): Flow<UserModel> {
        return loginNDS.signIn(key = key, password = password).flatMapMerge {
            userNDS.getUser(it)
        }.map {
            it.toUserModel()
        }
    }

    override suspend fun signUp(model: RegisterUserActionDataModel): Flow<UserModel> {
        return loginNDS.signUp(key = model.privateKey, password = model.password).flatMapMerge {
            userNDS.insertOrUpdateUser(user = model.toUserNetworkModel(id = it))
        }.map {
            it.toUserModel()
        }
    }

    override suspend fun isLoggedIn(): Flow<Boolean> {
        return loginNDS.isLoggedIn()
    }
}