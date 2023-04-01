package com.mukul.jan.primer.data.login.impl.network

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.channelFlowWithTimeout
import com.mukul.jan.primer.data.login.api.api.UserApi
import com.mukul.jan.primer.data.login.api.mapper.toUserNetworkModel
import com.mukul.jan.primer.data.login.api.mapper.toUserRealmModel
import com.mukul.jan.primer.data.login.api.network.UserNDS
import com.mukul.jan.primer.data.login.api.network.model.UserNetworkModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserNDSImpl @Inject constructor(
    private val api: UserApi,
    private val dispatcher: AppCoroutineDispatcher,
) : UserNDS {
    @Throws
    override suspend fun getLoggedInUser(): Flow<UserNetworkModel> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            send(api.getLoggedInUser().toUserNetworkModel())
        }
    }

    @Throws
    override suspend fun getUser(id: String): Flow<UserNetworkModel> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            send(api.getUser(id = id).toUserNetworkModel())
        }
    }

    @Throws
    override suspend fun insertOrUpdateUser(user: UserNetworkModel): Flow<UserNetworkModel> {
        return channelFlowWithTimeout(dispatcher = dispatcher.io) {
            api.insertOrUpdateUser(model = user.toUserRealmModel())
            send(user)
        }
    }
}