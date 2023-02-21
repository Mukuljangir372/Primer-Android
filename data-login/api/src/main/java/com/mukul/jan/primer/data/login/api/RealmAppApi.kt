package com.mukul.jan.primer.data.login.api

import io.realm.kotlin.mongodb.App

interface RealmAppApi {
   //returns realm app
   suspend fun getApp(): App
}

