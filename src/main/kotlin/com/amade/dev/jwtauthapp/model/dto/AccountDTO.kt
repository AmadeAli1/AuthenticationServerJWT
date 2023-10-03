package com.amade.dev.jwtauthapp.model.dto

data class AccountDTO(
    val id: String,
    val email: String,
    val username: String,
    val accessToken: String,
)
