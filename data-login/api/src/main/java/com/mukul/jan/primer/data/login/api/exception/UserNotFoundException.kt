package com.mukul.jan.primer.data.login.api.exception

class UserNotFoundException : Exception() {
    override fun getLocalizedMessage(): String? {
        return "User not found"
    }
}