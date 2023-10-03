package com.amade.dev.jwtauthapp

import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Encoders
import io.jsonwebtoken.security.Keys
import org.junit.jupiter.api.Test


class JwtAuthAppApplicationTests {

    @Test
    fun getKey() {
        val key = Keys.secretKeyFor(SignatureAlgorithm.HS256)
        println(Encoders.BASE64.encode(key.encoded))
    }

}
