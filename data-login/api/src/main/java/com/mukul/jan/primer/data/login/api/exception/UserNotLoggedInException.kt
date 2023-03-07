package com.mukul.jan.primer.data.login.api.exception

class UserNotLoggedInException : Exception() {
    override fun getLocalizedMessage(): String {
        return "User not logged in."
    }
}