package com.mukul.jan.primer.data.login.impl.hilt

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAppIdQualifier
import com.mu.jan.primer.common.RealmAppUserDomain
import com.mu.jan.primer.common.RealmAuthApiQualifier
import com.mukul.jan.primer.data.login.api.*
import com.mukul.jan.primer.data.login.impl.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun realmApp(
        @RealmAppIdQualifier appId: String,
        dispatchers: AppCoroutineDispatcher,
    ): RealmAppApi {
        return RealmAppApiImpl(
            appId = appId,
            dispatchers = dispatchers
        )
    }


    @Singleton
    @Provides
    fun authApi(
        @RealmAuthApiQualifier realmAuthApi: String,
        realmAppApi: RealmAppApi,
        dispatchers: AppCoroutineDispatcher,
    ): AuthApi {
        return AuthApiImpl(
            realmAuthApi = realmAuthApi,
            realmAppApi = realmAppApi,
            dispatchers = dispatchers
        )
    }

    @Singleton
    @Provides
    fun loginUserApi(
        realmAppApi: RealmAppApi,
        @RealmAppUserDomain userDomain: String,
        dispatchers: AppCoroutineDispatcher,
    ): LoginUserApi {
        return LoginUserApiImpl(
            realmAppApi = realmAppApi,
            userDomain = userDomain,
            dispatchers = dispatchers
        )
    }

    @Singleton
    @Provides
    fun registerUserApi(
        realmAppApi: RealmAppApi,
        @RealmAppUserDomain userDomain: String,
        dispatchers: AppCoroutineDispatcher,
    ): RegisterUserApi {
        return RegisterUserApiImpl(
            realmAppApi = realmAppApi,
            userDomain = userDomain,
            dispatchers = dispatchers
        )
    }

    @Singleton
    @Provides
    fun userDataApi(
        realmAppApi: RealmAppApi,
        dispatchers: AppCoroutineDispatcher,
    ): UserDataApi {
        return UserDataApiImpl(
            realmAppApi = realmAppApi,
            dispatchers = dispatchers
        )
    }

    @Singleton
    @Provides
    fun secureKeyApi(
        dispatchers: AppCoroutineDispatcher
    ): SecureKeyApi {
        return SecureKeyApiImpl(
            dispatchers = dispatchers
        )
    }
}
