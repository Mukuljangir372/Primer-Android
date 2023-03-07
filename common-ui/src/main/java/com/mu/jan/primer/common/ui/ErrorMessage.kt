package com.mu.jan.primer.common.ui

import androidx.annotation.StringRes

sealed interface ErrorMessage {
    data class StringType(val message: String) : ErrorMessage
    data class StringIdType(@StringRes val id: Int) : ErrorMessage
}