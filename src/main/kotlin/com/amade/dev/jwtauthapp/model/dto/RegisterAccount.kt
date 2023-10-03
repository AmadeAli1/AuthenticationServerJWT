package com.amade.dev.jwtauthapp.model.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

data class RegisterAccount(
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Length(min = 6, max = 60) val username: String,
    @field:NotBlank @field:Length(min = 6) val password: String,
)
