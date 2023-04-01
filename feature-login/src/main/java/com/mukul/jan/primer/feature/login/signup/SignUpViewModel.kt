package com.mukul.jan.primer.feature.login.signup

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.Message
import com.mu.jan.primer.common.Resource
import com.mukul.jan.primer.domain.RegisterUserUseCase
import com.mukul.jan.primer.domain.SecureKeyGenerateUseCase
import com.mukul.jan.primer.domain.container.SignInLocalDataContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val container: SignInLocalDataContainer,
    private val secureKeyGenerateUseCase: SecureKeyGenerateUseCase,
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<Message>,
        val username: String,
        val publicKey: String,
        val privateKey: String,
        val signUp: Boolean,
    ) {
        companion object {
            val EMPTY = State(
                isLoading = false,
                errorMessages = emptyList(),
                username = "",
                publicKey = "",
                privateKey = "",
                signUp = false
            )
        }

        fun toUiState(): UiState {
            return UiState.Details(
                isLoading = isLoading,
                errorMessages = errorMessages,
                username = username,
                privateKey = privateKey,
                publicKey = publicKey,
                signUp = signUp
            )
        }
    }

    sealed interface UiState {
        val isLoading: Boolean
        val errorMessages: List<Message>

        data class Details(
            override val isLoading: Boolean,
            override val errorMessages: List<Message>,
            val username: String,
            val privateKey: String,
            val publicKey: String,
            val signUp: Boolean,
        ) : UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState).stateIn(
        scope = viewModelScope, started = SharingStarted.Eagerly, initialValue = state.value
    )

    fun onSignUpRevert() {
        state.update { it.copy(signUp = false) }
    }

    fun showErrorMessage(@StringRes msg: Int) {
        showErrorMessage(
            Message.StringResType(
                id = UUID.randomUUID().mostSignificantBits, resId = msg
            )
        )
    }

    fun onErrorMessageShown(id: Long) {
        state.update { it.copy(errorMessages = it.errorMessages.filterNot { i -> i.id == id }) }
    }

    private fun showErrorMessage(msg: Message) {
        state.update { it.copy(errorMessages = listOf(msg)) }
    }

    private fun showLoading() {
        state.update { it.copy(isLoading = true) }
    }

    private fun hideLoading() {
        state.update { it.copy(isLoading = false) }
    }

    init {
        shakeDetails()
    }

    private fun shakeDetails() {
        viewModelScope.launch {
            val privateKey =
                secureKeyGenerateUseCase.invoke(SecureKeyGenerateUseCase.Params()).first()
            val publicKey =
                secureKeyGenerateUseCase.invoke(SecureKeyGenerateUseCase.Params()).first()
            val details = container.shake(generatePrivateKey = {
                privateKey
            }, generatePublicKey = {
                publicKey
            })
            state.update {
                it.copy(
                    username = details.username,
                    publicKey = details.publicKey,
                    privateKey = details.privateKey
                )
            }
        }
    }

    fun validateAndSignUp() {
        viewModelScope.launch {
            val details = container.signInDetail.value
            registerUserUseCase.invoke(
                RegisterUserUseCase.Params(
                    username = details.username,
                    password = details.password,
                    privateKey = details.privateKey,
                    publicKey = details.publicKey
                )
            ).collectLatest {
                bindResource(it)
            }
        }
    }

    private fun bindResource(resource: Resource<*>) {
        val loading = resource is Resource.Loading
        val errorMessage = when (resource) {
            is Resource.Failure -> resource.msg
            is Resource.Success -> resource.msg
            else -> null
        }

        if (loading) showLoading()
        else hideLoading()

        if (errorMessage != null) {
            showErrorMessage(errorMessage)
        }
    }

}