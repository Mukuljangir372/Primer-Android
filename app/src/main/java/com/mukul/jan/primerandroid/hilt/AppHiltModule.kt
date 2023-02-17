package com.mukul.jan.primerandroid.hilt

import com.mu.jan.primer.common.AppCoroutineDispatcher
import com.mu.jan.primer.common.RealmAppIdQualifier
import com.mu.jan.primer.common.RealmAuthApiQualifier
import com.mukul.jan.primerandroid.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object AppHiltModule {

    @RealmAppIdQualifier
    @Provides
    fun provideRealmAppId(): String {
        return BuildConfig.APP_MONGO_REALM_APP_ID
    }

    @RealmAuthApiQualifier
    @Provides
    fun provideRealmAuthApi(): String {
        return BuildConfig.APP_MONGO_REALM_AUTH_API
    }

    @Provides
    fun provideAppCoroutineDispatcher(): AppCoroutineDispatcher {
        return AppCoroutineDispatcher(
            io = Dispatchers.IO,
            main = Dispatchers.Main,
            default = Dispatchers.Default
        )
    }
}