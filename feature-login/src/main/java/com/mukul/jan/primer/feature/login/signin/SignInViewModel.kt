package com.mukul.jan.primer.feature.login.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.Message
import kotlinx.coroutines.flow.*

class SignInViewModel : ViewModel() {
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
            return UiState.SignIn (
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
        ): UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state.value
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

    fun signIn() {

    }
}