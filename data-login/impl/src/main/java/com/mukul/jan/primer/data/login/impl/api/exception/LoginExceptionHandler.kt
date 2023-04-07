package com.mukul.jan.primer.data.login.impl.api.exception

import com.mu.jan.primer.common.ExceptionHandler
import io.realm.kotlin.mongodb.exceptions.InvalidCredentialsException
import io.realm.kotlin.mongodb.exceptions.UserAlreadyExistsException
import javax.inject.Inject

class LoginExceptionHandler @Inject constructor() : ExceptionHandler {
    override fun toReadable(throwable: Throwable?): String {
        return when (throwable) {
            is InvalidCredentialsException -> "Credentials are incorrect"
            is UserAlreadyExistsException -> "User already exists"
            else -> "Something went wrong! please try in some time"
        }
    }

    override fun toReadableException(throwable: Throwable?): Exception {
        return Exception(toReadable(throwable), throwable)
    }
}