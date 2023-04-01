package com.mu.jan.primer.common

import androidx.annotation.StringRes
import java.util.*

sealed interface Message {
    val id: Long

    data class StringType(
        override val id: Long, val message: String
    ) : Message {
        companion object {
            fun new(message: String): StringType {
                return StringType(
                    id = UUID.randomUUID().mostSignificantBits, message = message
                )
            }
        }
    }

    data class StringResType(
        override val id: Long, @StringRes val resId: Int
    ) : Message {
        companion object {
            fun new(@StringRes resId: Int): StringResType {
                return StringResType(
                    id = UUID.randomUUID().mostSignificantBits, resId = resId
                )
            }
        }
    }
}