package com.mukul.jan.primer.data.login.api

import com.mu.jan.primer.common.RealmAppIdQualifier
import io.realm.kotlin.log.LogLevel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.AppConfiguration
import javax.inject.Inject

interface RealmAppApi {
    fun getApp(): App
}

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