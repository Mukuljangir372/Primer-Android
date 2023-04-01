package com.mukul.jan.primer.domain

import com.mu.jan.primer.common.BaseUseCase
import com.mu.jan.primer.common.Message
import com.mu.jan.primer.common.Resource
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.data.login.api.repo.LoginRepo
import com.mukul.jan.primer.data.login.api.repo.model.RegisterUserActionDataModel
import com.mukul.jan.primer.data.login.api.repo.model.UserModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repo: LoginRepo
) : BaseUseCase<RegisterUserUseCase.Params, Flow<Resource<UserModel>>>() {
    data class Params(
        val username: String,
        val password: String,
        val privateKey: String,
        val publicKey: String,
    ) {
        fun toDataModel(): RegisterUserActionDataModel {
            val source = this
            return RegisterUserActionDataModel(
                username = source.username,
                password = source.password,
                privateKey = source.privateKey,
                publicKey = source.publicKey
            )
        }
    }

    override suspend fun doWork(params: Params): Flow<Resource<UserModel>> {
        return channelFlow<Resource<UserModel>> {
            checkForValidation(params)
            repo.register(model = params.toDataModel()).onStart {
                send(Resource.Loading())
            }.catch {
                throw it
            }.collectLatest {
                send(
                    Resource.Success(
                        data = it,
                        msg = Message.StringResType.new(resId = R.string.user_register_successfully)
                    )
                )
            }
        }.catch {
            emit(Resource.Failure(msg = Message.StringType.new(it.message ?: it.localizedMessage)))
        }
    }

    @Throws
    private fun checkForValidation(params: Params) {
        check(params.username.trim().isNotEmpty()) { "Username can't empty" }
        check(params.password.trim().isEmpty()) { "Password can't empty" }
        check(params.password.trim().length <= 6) { "Password length must be greater then 6 chars" }
        check(params.password.trim().length > 12) { "Password length must be lower then 12 chars" }
        check(params.privateKey.trim().isNotEmpty()) { "Private key can't empty" }
        check(params.publicKey.trim().isNotEmpty()) { "Public key can't empty" }
    }
}