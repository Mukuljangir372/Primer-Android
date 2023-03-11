package com.mukul.jan.primer.data.login.api.model

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

@Suppress("DEPRECATION")
class UserRealmModel: RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var username: String = ""
    var privateKey: String = ""
    var publicKey: String = ""
}