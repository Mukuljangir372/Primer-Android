package com.mukul.jan.primer.feature.login.choose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.ui.ErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ChooseUsernameViewModel @Inject constructor() : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<ErrorMessage>,
        val username: String,
    ) {
        companion object {
            val EMPTY = State(
                isLoading = false,
                errorMessages = emptyList(),
                username = ""
            )
        }

        fun toUiState(): UiState {
            return UiState.ChooseName(
                isLoading = isLoading,
                errorMessages = errorMessages,
                username = username
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

}



