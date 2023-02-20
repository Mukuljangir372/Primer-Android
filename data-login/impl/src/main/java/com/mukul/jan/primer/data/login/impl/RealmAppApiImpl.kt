package com.mukul.jan.primer.data.login.impl

import com.mu.jan.primer.common.RealmAppIdQualifier
import com.mukul.jan.primer.data.login.api.RealmAppApi
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import javax.inject.Inject

class RealmAppApiImpl @Inject constructor(
    @RealmAppIdQualifier private val appId: String
) : RealmAppApi {
    override fun getApp(): App {
        return App.create(
            AppConfiguration.Builder(appId)
                .log(LogLevel.ALL)
                .build()
        )
    }
}