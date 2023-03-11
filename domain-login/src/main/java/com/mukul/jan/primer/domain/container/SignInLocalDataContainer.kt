package com.mukul.jan.primer.domain.container

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.getAndUpdate

class SignInLocalDataContainer {
    data class SignInDetail(
        val username: String,
        val password: String,
        val privateKey: String,
        val publicKey: String,
    ) {
        companion object {
            val EMPTY = SignInDetail(
                username = "",
                password = "",
                privateKey = "",
                publicKey = ""
            )
        }
    }

    private val signInDetailFlow = MutableStateFlow(SignInDetail.EMPTY)
    val signInDetail: StateFlow<SignInDetail> get() = signInDetailFlow
    fun update(block: (SignInDetail) -> SignInDetail) {
        signInDetailFlow.getAndUpdate { block.invoke(it) }
    }
}