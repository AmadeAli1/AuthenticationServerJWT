package com.amade.dev.jwtauthapp.utils

import java.util.*

fun String.toUUID(): UUID {
    return UUID.fromString(this)
}