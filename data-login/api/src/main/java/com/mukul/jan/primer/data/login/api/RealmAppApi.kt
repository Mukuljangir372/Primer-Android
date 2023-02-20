package com.mukul.jan.primer.data.login.api

import io.realm.kotlin.mongodb.App

interface RealmAppApi {
    fun getApp(): App
}

