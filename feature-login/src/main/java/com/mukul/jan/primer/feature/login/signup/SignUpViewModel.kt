package com.mukul.jan.primer.feature.login.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mu.jan.primer.common.ui.ErrorMessage
import com.mukul.jan.primer.domain.container.SignInLocalDataContainer
import com.mukul.jan.primer.domain.generator.SecureKeyGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val container: SignInLocalDataContainer,
    private val keyGenerator: SecureKeyGenerator
) : ViewModel() {
    data class State(
        val isLoading: Boolean,
        val errorMessages: List<ErrorMessage>,
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
        val errorMessages: List<ErrorMessage>

        data class Details(
            override val isLoading: Boolean,
            override val errorMessages: List<ErrorMessage>,
            val username: String,
            val privateKey: String,
            val publicKey: String,
            val signUp: Boolean,
        ) : UiState
    }

    private val state = MutableStateFlow(State.EMPTY)

    val uiState = state.map(State::toUiState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = state.value
        )

    fun onSignUpRevert() {
        state.update { it.copy(signUp = false) }
    }

    fun onErrorMessageShown(id: Long) {
        state.update { it.copy(errorMessages = it.errorMessages.filterNot { i -> i.id == id }) }
    }

    private fun showErrorMessage(msg: ErrorMessage) {
        state.update { it.copy(errorMessages = listOf(msg)) }
    }

    private fun clearErrorMessages() {
        state.update { it.copy(errorMessages = emptyList()) }
    }

    init {
        viewModelScope.launch {
            prepareAndMutateDetails()
        }
    }

    private suspend fun prepareAndMutateDetails() {
        val details = container.signInDetail.value
        val privateKey = details.privateKey.ifEmpty {
            val key = keyGenerator.generate()
            container.update { it.copy(privateKey = key) }
            key
        }
        val publicKey = details.publicKey.ifEmpty {
            val key = keyGenerator.generate()
            container.update { it.copy(publicKey = key) }
            key
        }
        clearErrorMessages()
        state.update {
            it.copy(
                username = details.username,
                publicKey = publicKey,
                privateKey = privateKey
            )
        }
    }

    fun validateAndSignUp() {

    }

}