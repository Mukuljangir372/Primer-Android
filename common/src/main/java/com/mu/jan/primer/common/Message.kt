package com.mu.jan.primer.common

import androidx.annotation.StringRes

sealed interface Message {
    val id: Long

    data class StringType(
        override val id: Long, val message: String
    ) : Message

    data class StringResType(
        override val id: Long, @StringRes val resId: Int
    ) : Message
}