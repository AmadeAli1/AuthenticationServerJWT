package com.amade.dev.jwtauthapp.model

import java.util.*

data class Word(
    val id: String = UUID.randomUUID().toString(),
    val message: String = "Hello:: ${id[9]}",
)
