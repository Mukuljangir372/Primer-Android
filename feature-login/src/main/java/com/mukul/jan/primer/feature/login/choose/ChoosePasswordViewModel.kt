package com.mukul.jan.primer.feature.login.choose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.Message
import com.mu.jan.primer.common.validator.PasswordValidator
import com.mukul.jan.primer.domain.container.SignInLocalDataContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ChoosePasswordViewModel @Inject constructor(
    private val container: SignInLocalDataContainer
) : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<Message>,
        val password: String,
        val confirmPassword: String,
        val passwordValidated: Boolean,
    ) {
        companion object {
            val EMPTY = State(
                isLoading = false,
                errorMessages = emptyList(),
                password = "",
                confirmPassword = "",
                passwordValidated = false
            )
        }

        fun toUiState(): UiState {
            return UiState.ChoosePassword(
                isLoading = isLoading,
                errorMessages = errorMessages,
                password = password,
                confirmPassword = confirmPassword,
                passwordValidated = passwordValidated
            )
        }
    }

    sealed interface UiState {
        val isLoading: Boolean
        val errorMessages: List<Message>

        data class ChoosePassword(
            override val isLoading: Boolean,
            override val errorMessages: List<Message>,
            val password: String,
            val confirmPassword: String,
            val passwordValidated: Boolean,
        ) : UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState).stateIn(
        scope = viewModelScope, started = SharingStarted.Eagerly, initialValue = state.value
    )

    fun onPasswordChanged(_value: String) {
        state.update { it.copy(password = _value) }
    }

    fun onConfirmPasswordChange(_value: String) {
        state.update { it.copy(confirmPassword = _value) }
    }

    fun onPasswordValidationRevert() {
        state.update { it.copy(passwordValidated = false) }
    }

    fun onErrorMessageShown(id: Long) {
        state.update { it.copy(errorMessages = it.errorMessages.filterNot { i -> i.id != id }) }
    }

    private fun showErrorMessage(message: Message) {
        state.update { it.copy(errorMessages = listOf(message)) }
    }

    private fun clearErrorMessages() {
        state.update { it.copy(errorMessages = emptyList()) }
    }

    fun validate() {
        val password = state.value.password
        val confirmPassword = state.value.confirmPassword

        val params = PasswordValidator.Params(password, confirmPassword)
        val error = PasswordValidator().safeValidate(params)
        if (error.isNotEmpty()) {
            showErrorMessage(Message.StringType.new(error))
            return
        }

        clearErrorMessages()
        state.update { it.copy(errorMessages = emptyList(), passwordValidated = true) }
        container.update { it.copy(password = password) }
    }
}
























