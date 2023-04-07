package com.mu.jan.primer.common.validator

import androidx.core.text.isDigitsOnly

@Suppress("RegExpUnexpectedAnchor")
class PasswordValidator : Validator<PasswordValidator.Params, Boolean, String> {
    data class Params(val password: String, val confirmPassword: String)

    override fun validate(params: Params): Boolean {
        check(params.password.trim().isNotEmpty()) { "Password can't empty" }
        check(params.password.trim().length > 6) { "Password length must be greater then 6 chars" }
        check(params.password.trim().length <= 12) { "Password length must be lower then 12 chars" }
        check(hasLetters(params.password)) { "Password must has special chars" }
        check(params.confirmPassword == params.password) { "Password not match" }
        return true
    }

    private fun hasLetters(string: String): Boolean {
        return !string.isDigitsOnly()
    }

    override fun safeValidate(params: Params): String {
        return try {
            validate(params)
            ""
        } catch (e: Exception) {
            e.message ?: ""
        }
    }
}