package com.mukul.jan.primer.data.login.impl.api

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.api.RealmAppApi
import com.mukul.jan.primer.data.login.api.api.UserApi
import com.mukul.jan.primer.data.login.api.api.model.UserRealmModel
import com.mukul.jan.primer.data.login.api.exception.UserNotFoundException
import com.mukul.jan.primer.data.login.api.exception.UserNotLoggedInException
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.types.ObjectId
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserApiImpl @Inject constructor(
    private val realmAppApi: RealmAppApi,
    private val dispatchers: AppCoroutineDispatcher,
) : UserApi {
    @Throws
    override suspend fun getLoggedInUser(): UserRealmModel {
        return withContext(dispatchers.io) {
            val loggedInUserId = realmAppApi.getApp().currentUser?.id
            if (loggedInUserId.isNullOrEmpty()) throw UserNotLoggedInException()
            getUser(id = loggedInUserId)
        }
    }

    @Suppress("DEPRECATION")
    @Throws
    override suspend fun getUser(id: String): UserRealmModel {
        return withContext(dispatchers.io) {
            val realm = realmAppApi.getOpenedSyncRealm()
            realm.query(
                clazz = UserRealmModel::class,
                query = "_id == $0",
                ObjectId.from(id),
            ).first().find() ?: throw UserNotFoundException()
        }
    }

    @Throws
    override suspend fun insertOrUpdateUser(model: UserRealmModel) {
        return withContext(dispatchers.io) {
            val realm = realmAppApi.getOpenedSyncRealm()
            realm.writeBlocking {
                copyToRealm(instance = model, updatePolicy = UpdatePolicy.ALL)
            }
        }
    }
}




