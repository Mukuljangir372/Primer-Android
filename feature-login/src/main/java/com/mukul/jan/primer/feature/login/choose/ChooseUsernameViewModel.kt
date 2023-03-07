package com.mukul.jan.primer.feature.login.choose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.ui.ErrorMessage
import com.mukul.jan.primer.feature.login.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ChooseUsernameViewModel @Inject constructor() : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<ErrorMessage>,
        val username: String,
        val usernameValidated: Boolean
    ) {
        companion object {
            val EMPTY = State(
                isLoading = false,
                errorMessages = emptyList(),
                username = "",
                usernameValidated = false,
            )
        }

        fun toUiState(): UiState {
            return UiState.ChooseName(
                isLoading = isLoading,
                errorMessages = errorMessages,
                username = username,
                usernameValidated = usernameValidated
            )
        }
    }

    sealed interface UiState {
        val isLoading: Boolean
        val errorMessages: List<ErrorMessage>

        data class ChooseName(
            override val isLoading: Boolean,
            override val errorMessages: List<ErrorMessage>,
            val username: String,
            val usernameValidated: Boolean,
        ) : UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state.value.toUiState()
        )

    fun onNameChange(_value: String) {
        state.update {
            it.copy(username = _value)
        }
    }

    fun onErrorMessageShown(id: Long) {
        state.getAndUpdate {
            it.copy(errorMessages = it.errorMessages.filterNot { msg -> msg.id == id })
        }
    }

    fun onUsernameValidationComplete() {
        state.update {
            it.copy(usernameValidated = false)
        }
    }

    private fun showErrorMessage(msg: ErrorMessage) {
        state.getAndUpdate {
            it.copy(errorMessages = it.errorMessages + msg)
        }
    }

    fun validateUsername() {
        val username = (uiState.value as UiState.ChooseName).username //guaranteed cast
        if (username.trim().isEmpty()) {
            val msg = ErrorMessage.StringIdType(
                id = UUID.randomUUID().mostSignificantBits,
                resId = R.string.please_enter_your_name
            )
            showErrorMessage(msg)
        } else {
            state.update {
                it.copy(usernameValidated = true)
            }
        }
    }
}



