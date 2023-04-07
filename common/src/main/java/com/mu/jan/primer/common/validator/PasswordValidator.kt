package com.mu.jan.primer.common.validator

@Suppress("RegExpUnexpectedAnchor")
class PasswordValidator : Validator<PasswordValidator.Params, Boolean, String> {
    data class Params(val password: String, val confirmPassword: String)

    private val pattern =
        "\"^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!])(?=\\\\S+\$).{4,}\$\"".toPattern()

    override fun validate(params: Params): Boolean {
        check(params.password.trim().isNotEmpty()) { "Password can't empty" }
        check(params.password.trim().length > 6) { "Password length must be greater then 6 chars" }
        check(params.password.trim().length <= 12) { "Password length must be lower then 12 chars" }
        check(hasPasswordPattern(params.password)) { "Password must has special chars" }
        check(params.confirmPassword == params.password) { "Password not match" }
        return true
    }

    private fun hasPasswordPattern(string: String): Boolean {
        return pattern.matcher(string).matches()
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