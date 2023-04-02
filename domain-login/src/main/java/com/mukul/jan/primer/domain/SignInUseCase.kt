package com.mukul.jan.primer.domain

import com.mu.jan.primer.common.BaseUseCase
import com.mu.jan.primer.common.Message
import com.mu.jan.primer.common.Resource
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.data.login.api.repo.LoginRepo
import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repo: LoginRepo,
) : BaseUseCase<SignInUseCase.Params, Flow<Resource<UserModel>>>() {
    data class Params(
        val privateKey: String,
        val password: String,
    )

    override suspend fun doWork(params: Params): Flow<Resource<UserModel>> {
        return channelFlow<Resource<UserModel>> {
            checkForValidation(params)
            repo.signIn(key = params.privateKey, password = params.password).onStart {
                send(Resource.Loading())
            }.catch {
                throw it
            }.collectLatest {
                send(
                    Resource.Success(
                        data = it,
                        msg = Message.StringResType.new(resId = R.string.user_logged_in_successfully)
                    )
                )
            }
        }.catch {
            emit(Resource.Failure(msg = Message.StringType.new(it.message ?: it.localizedMessage)))
        }
    }

    @Throws
    private fun checkForValidation(params: Params) {
        check(params.privateKey.trim().isNotEmpty()) { "Private key can't empty" }
        check(params.privateKey.trim().length == 15) { "Private key is not valid" }
        check(params.password.trim().isNotEmpty()) { "Password can't empty" }
        check(params.password.trim().length > 6) { "Password length must be greater then 6 chars" }
        check(params.password.trim().length <= 12) { "Password length must be lower then 12 chars" }
    }
}