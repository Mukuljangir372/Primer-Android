package com.mu.jan.primer.common.ui

import androidx.annotation.StringRes

sealed interface ErrorMessage {
    val id: Long

    data class StringType(
        override val id: Long, val message: String
    ) : ErrorMessage

    data class StringIdType(
        override val id: Long, @StringRes val resId: Int
    ) : ErrorMessage
}