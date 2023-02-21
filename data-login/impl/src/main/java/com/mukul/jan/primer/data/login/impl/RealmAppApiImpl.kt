package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAppIdQualifier
import com.mukul.jan.primer.data.login.api.RealmAppApi
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RealmAppApiImpl @Inject constructor(
    @RealmAppIdQualifier private val appId: String,
    private val dispatchers: AppCoroutineDispatcher,
) : RealmAppApi {
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
}