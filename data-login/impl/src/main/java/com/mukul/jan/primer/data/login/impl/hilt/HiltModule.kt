package com.mukul.jan.primer.data.login.impl.hilt

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mukul.jan.primer.data.login.api.*
import com.mukul.jan.primer.data.login.impl.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModule {

    @Singleton
    @Binds
    abstract fun bindRealmAppApi(
        impl: RealmAppApiImpl
    ): RealmAppApi


    @Singleton
    @Binds
    abstract fun bindAuthApi(
        impl: AuthApiImpl
    ): AuthApi

    @Singleton
    @Binds
    abstract fun bindLoginUserApi(
        impl: LoginUserApiImpl
    ): LoginUserApi

    @Singleton
    @Binds
    abstract fun bindRegisterUserApi(
        impl: RegisterUserApiImpl
    ): RegisterUserApi

    @Singleton
    @Binds
    abstract fun bindUserDataApi(
        impl: UserDataApiImpl
    ): UserDataApi
}
