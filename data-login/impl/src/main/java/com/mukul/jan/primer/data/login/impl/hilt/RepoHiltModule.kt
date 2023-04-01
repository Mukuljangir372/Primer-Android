package com.mukul.jan.primer.data.login.impl.hilt

import com.mukul.jan.primer.data.login.api.repo.LoginRepo
import com.mukul.jan.primer.data.login.api.repo.SecureKeyRepo
import com.mukul.jan.primer.data.login.api.repo.UserRepo
import com.mukul.jan.primer.data.login.impl.repo.LoginRepoImpl
import com.mukul.jan.primer.data.login.impl.repo.SecureKeyRepoImpl
import com.mukul.jan.primer.data.login.impl.repo.UserRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoHiltModule {
    @Singleton
    @Binds
    abstract fun bindUserRepo(impl: UserRepoImpl): UserRepo

    @Singleton
    @Binds
    abstract fun bindLoginRepo(impl: LoginRepoImpl): LoginRepo

    @Singleton
    @Binds
    abstract fun bindSecureKeyRepo(impl: SecureKeyRepoImpl): SecureKeyRepo
}