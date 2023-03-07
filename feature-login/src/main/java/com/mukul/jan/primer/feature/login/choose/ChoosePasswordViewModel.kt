package com.mukul.jan.primer.feature.login.choose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.ui.ErrorMessage
import kotlinx.coroutines.flow.*

class ChoosePasswordViewModel : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<ErrorMessage>,
        val password: String,
        val confirmPassword: String
    ) {
        companion object {
            val EMPTY = State(
                isLoading = false,
                errorMessages = emptyList(),
                password = "",
                confirmPassword = ""
            )
        }

        fun toUiState(): UiState {
            return UiState.ChoosePassword(
                isLoading = isLoading,
                errorMessages = errorMessages,
                password = password,
                confirmPassword = confirmPassword
            )
        }
    }

    sealed interface UiState {
        val isLoading: Boolean
        val errorMessages: List<ErrorMessage>

        data class ChoosePassword(
            override val isLoading: Boolean,
            override val errorMessages: List<ErrorMessage>,
            val password: String,
            val confirmPassword: String,
        ) : UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state.value
        )

    fun onPasswordChanged(_value: String) {
        state.update { it.copy(password = _value) }
    }

    fun onConfirmPasswordChange(_value: String) {
        state.update { it.copy(confirmPassword = _value) }
    }
}