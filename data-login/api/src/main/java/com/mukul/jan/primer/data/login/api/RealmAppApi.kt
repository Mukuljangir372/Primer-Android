package com.mukul.jan.primer.data.login.api

import io.realm.kotlin.Realm
import io.realm.kotlin.mongodb.App

interface RealmAppApi {
    suspend fun getApp(): App
    suspend fun getOpenSyncRealm(): Realm
}

