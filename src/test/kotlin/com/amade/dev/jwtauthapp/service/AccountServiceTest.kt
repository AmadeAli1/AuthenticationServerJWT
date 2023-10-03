package com.amade.dev.jwtauthapp.service

import com.amade.dev.jwtauthapp.model.Account
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AccountServiceTest @Autowired constructor(
    private val accountService: AccountService
) {

    @Test
    fun findByUsername() {

        runBlocking {

            accountService.findByUsername("amade").awaitSingleOrNull()?.let {
                println("Find")
            }.let {
                println("Not found")
            }

        }

    }
}