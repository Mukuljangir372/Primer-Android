package com.mukul.jan.primer.data.login.impl.repo

import com.mukul.jan.primer.data.login.api.mapper.toUserModel
import com.mukul.jan.primer.data.login.api.mapper.toUserNetworkModel
import com.mukul.jan.primer.data.login.api.network.UserNDS
import com.mukul.jan.primer.data.login.api.repo.UserRepo
import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val nds: UserNDS
) : UserRepo {
    override suspend fun getLoggedInUser(): Flow<UserModel> {
        return nds.getLoggedInUser().map { it.toUserModel() }
    }

    override suspend fun getUser(id: String): Flow<UserModel> {
        return nds.getUser(id).map { it.toUserModel() }
    }

    override suspend fun insertOrUpdateUser(user: UserModel): Flow<UserModel> {
        return nds.insertOrUpdateUser(user = user.toUserNetworkModel()).map { it.toUserModel() }
    }
}