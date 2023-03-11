package com.mukul.jan.primer.domain.hilt

import com.mukul.jan.primer.domain.generator.SecureKeyGenerator
import com.mukul.jan.primer.domain.generator.SecureKeyGeneratorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GeneratorHiltModule {
    @Singleton
    @Binds
    abstract fun provideSecureKeyGenerator(impl: SecureKeyGeneratorImpl): SecureKeyGenerator
}