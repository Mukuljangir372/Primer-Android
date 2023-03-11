package com.mukul.jan.primer.domain.hilt

import com.mukul.jan.primer.domain.container.SignInLocalDataContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContainerHiltModule {
    @Singleton
    @Provides
    fun provideSignInLocalDataContainer(): SignInLocalDataContainer {
        return SignInLocalDataContainer()
    }
}