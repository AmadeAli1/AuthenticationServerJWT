package com.amade.dev.jwtauthapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtAuthAppApplication

fun main(args: Array<String>) {
    runApplication<JwtAuthAppApplication>(*args)
}
