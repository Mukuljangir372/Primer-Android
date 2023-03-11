package com.mukul.jan.primer.domain.hilt

import com.mukul.jan.primer.data.login.api.SecureKeyApi
import com.mukul.jan.primer.domain.generator.SecureKeyGenerator
import com.mukul.jan.primer.domain.generator.SecureKeyGeneratorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GeneratorHiltModule {
    @Provides
    @Singleton
    fun provideSecureKeyGenerator(api: SecureKeyApi): SecureKeyGenerator {
        return SecureKeyGeneratorImpl(api)
    }
}