package com.mukul.jan.primer.data.login.api.mapper

import com.mukul.jan.primer.data.login.api.api.model.UserRealmModel
import com.mukul.jan.primer.data.login.api.network.model.UserNetworkModel
import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import io.realm.kotlin.types.ObjectId

fun UserRealmModel.toUserNetworkModel(): UserNetworkModel {
    val source = this
    return UserNetworkModel(
        _id = source._id.toString(),
        username = source.username,
        privateKey = source.privateKey,
        publicKey = source.publicKey
    )
}

@Suppress("DEPRECATION")
fun UserNetworkModel.toUserRealmModel(): UserRealmModel {
    val source = this
    return UserRealmModel().apply {
        _id = ObjectId.from(source._id)
        username = source.username
        privateKey = source.privateKey
        publicKey = source.publicKey
    }
}

fun UserNetworkModel.toUserModel(): UserModel {
    val source = this
    return UserModel(
        _id = source._id,
        username = source.username,
        privateKey = source.privateKey,
        publicKey = source.publicKey,
    )
}

fun UserModel.toUserNetworkModel(): UserNetworkModel {
    val source = this
    return UserNetworkModel(
        _id = source._id,
        username = source.username,
        privateKey = source.privateKey,
        publicKey = source.publicKey
    )
}