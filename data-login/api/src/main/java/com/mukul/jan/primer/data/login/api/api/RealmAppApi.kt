package com.mukul.jan.primer.data.login.api.api

import io.realm.kotlin.Realm
import io.realm.kotlin.mongodb.App

interface RealmAppApi {
    @Throws
    suspend fun getApp(): App

    @Throws
    suspend fun getOpenedSyncRealm(): Realm
}

