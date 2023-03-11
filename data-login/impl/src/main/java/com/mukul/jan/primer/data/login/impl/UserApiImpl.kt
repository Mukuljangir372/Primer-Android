package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.RealmAppApi
import com.mukul.jan.primer.data.login.api.UserApi
import com.mukul.jan.primer.data.login.api.exception.UserNotFoundException
import com.mukul.jan.primer.data.login.api.exception.UserNotLoggedInException
import com.mukul.jan.primer.data.login.api.model.UserRealmModel
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

    @Throws
    override suspend fun getUser(id: String): UserRealmModel {
        return withContext(dispatchers.io) {
            val realm = realmAppApi.getOpenSyncRealm()
            realm.query(
                clazz = UserRealmModel::class,
                query = "_id == $0",
                id,
            ).first().find() ?: throw UserNotFoundException()
        }
    }

    @Throws
    override suspend fun insertOrUpdateUser(model: UserRealmModel) {
        return withContext(dispatchers.io) {
            val app = realmAppApi.getApp()
            val loggedInUserId = app.currentUser?.id
            if (loggedInUserId.isNullOrEmpty()) throw UserNotLoggedInException()
            val realm = realmAppApi.getOpenSyncRealm()
            realm.writeBlocking {
                copyToRealm(model)
            }
        }
    }
}




