package com.mukul.jan.primer.feature.login.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.Message
import com.mu.jan.primer.common.Resource
import com.mukul.jan.primer.domain.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<Message>,
        val privateKey: String,
        val password: String,
        val isLoggedIn: Boolean,
    ) {
        companion object {
            val EMPTY = State(
                isLoading = false,
                errorMessages = emptyList(),
                privateKey = "",
                password = "",
                isLoggedIn = false
            )
        }

        fun toUiState(): UiState {
            return UiState.SignIn(
                isLoading = isLoading,
                errorMessages = errorMessages,
                privateKey = privateKey,
                password = password,
                isLoggedIn = isLoggedIn
            )
        }
    }

    sealed interface UiState {
        val isLoading: Boolean
        val errorMessages: List<Message>

        data class SignIn(
            override val isLoading: Boolean,
            override val errorMessages: List<Message>,
            val privateKey: String,
            val password: String,
            val isLoggedIn: Boolean,
        ) : UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState).stateIn(
        scope = viewModelScope, started = SharingStarted.Eagerly, initialValue = state.value
    )

    fun onPrivateKeyChange(value: String) {
        state.update { it.copy(privateKey = value) }
    }

    fun onPasswordChange(value: String) {
        state.update { it.copy(password = value) }
    }

    fun onLoggedInSuccess() {
        state.update { it.copy(isLoggedIn = false) }
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

    fun signIn() {
        viewModelScope.launch {
            val details = state.value
            signInUseCase.invoke(
                SignInUseCase.Params(
                    privateKey = details.privateKey, password = details.password
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