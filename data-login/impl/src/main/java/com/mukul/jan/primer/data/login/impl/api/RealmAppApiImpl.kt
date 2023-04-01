package com.mukul.jan.primer.data.login.impl.api

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAppIdQualifier
import com.mukul.jan.primer.data.login.api.api.RealmAppApi
import com.mukul.jan.primer.data.login.api.api.model.UserRealmModel
import com.mukul.jan.primer.data.login.api.exception.UserNotLoggedInException
import io.realm.kotlin.Realm
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealmAppApiImpl @Inject constructor(
    @RealmAppIdQualifier private val appId: String,
    private val dispatchers: AppCoroutineDispatcher,
) : RealmAppApi {
    @Throws
    override suspend fun getApp(): App {
        return withContext(dispatchers.io) {
            App.create(
                AppConfiguration
                    .Builder(appId)
                    .log(LogLevel.ALL)
                    .build()
            )
        }
    }

    @Throws
    override suspend fun getOpenedSyncRealm(): Realm {
        return withContext(dispatchers.io) {
            val user = getApp().currentUser ?: throw UserNotLoggedInException()
            val schemas = setOf(UserRealmModel::class)
            val config = SyncConfiguration.Builder(user, appId, schemas).build()
            Realm.open(config)
        }
    }
}