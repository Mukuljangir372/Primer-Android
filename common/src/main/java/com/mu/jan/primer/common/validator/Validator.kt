package com.mu.jan.primer.common.validator

interface Validator<Params, Result, ValidationResult> {
    fun validate(params: Params): Result
    fun safeValidate(params: Params): ValidationResult
}