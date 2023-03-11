package com.mukul.jan.primer.data.login.impl.hilt

import com.mukul.jan.primer.data.login.api.*
import com.mukul.jan.primer.data.login.impl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModule {

    @Singleton
    @Binds
    abstract fun realmApp(impl: RealmAppApiImpl): RealmAppApi

    @Singleton
    @Binds
    abstract fun authApi(impl: AuthApiImpl): AuthApi

    @Singleton
    @Binds
    abstract fun loginUserApi(impl: LoginUserApiImpl): LoginUserApi

    @Singleton
    @Binds
    abstract fun registerUserApi(impl: RegisterUserApiImpl): RegisterUserApi


    @Singleton
    @Binds
    abstract fun userDataApi(impl: UserDataApiImpl): UserDataApi

    @Singleton
    @Binds
    abstract fun bindSecureApi(impl: SecureKeyApiImpl): SecureKeyApi
}