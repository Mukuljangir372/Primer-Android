package com.mukul.jan.primer.data.login.impl.hilt

import com.mukul.jan.primer.data.login.api.*
import com.mukul.jan.primer.data.login.api.api.*
import com.mukul.jan.primer.data.login.impl.*
import com.mukul.jan.primer.data.login.impl.api.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiHiltModule {

    @Singleton
    @Binds
    abstract fun realmApp(impl: RealmAppApiImpl): RealmAppApi

    @Singleton
    @Binds
    abstract fun authApi(impl: AuthApiImpl): AuthApi

    @Singleton
    @Binds
    abstract fun loginUserApi(impl: LoginApiImpl): LoginApi

    @Singleton
    @Binds
    abstract fun userDataApi(impl: UserApiImpl): UserApi

    @Singleton
    @Binds
    abstract fun bindSecureApi(impl: SecureKeyApiImpl): SecureKeyApi
}