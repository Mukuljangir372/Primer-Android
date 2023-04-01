package com.mukul.jan.primer.data.login.impl.hilt

import com.mukul.jan.primer.data.login.api.network.LoginNDS
import com.mukul.jan.primer.data.login.api.network.SecureKeyNDS
import com.mukul.jan.primer.data.login.api.network.UserNDS
import com.mukul.jan.primer.data.login.impl.network.LoginNDSImpl
import com.mukul.jan.primer.data.login.impl.network.SecureKeyNDSImpl
import com.mukul.jan.primer.data.login.impl.network.UserNDSImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NDSHiltModule {
    @Singleton
    @Binds
    abstract fun bindLoginNDS(impl: LoginNDSImpl): LoginNDS

    @Singleton
    @Binds
    abstract fun bindUserNDS(impl: UserNDSImpl): UserNDS

    @Singleton
    @Binds
    abstract fun bindSecureKeyNDS(impl: SecureKeyNDSImpl): SecureKeyNDS
}