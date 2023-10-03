package com.amade.dev.jwtauthapp.service

import com.amade.dev.jwtauthapp.exception.ApiException
import com.amade.dev.jwtauthapp.exception.ApiException.RegisterAccountException
import com.amade.dev.jwtauthapp.model.Account
import com.amade.dev.jwtauthapp.model.dto.RegisterAccount
import com.amade.dev.jwtauthapp.repository.AccountRepository
import com.amade.dev.jwtauthapp.utils.toUUID
import kotlinx.coroutines.reactor.mono
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service("AccountService")
class AccountService(
    private val repository: AccountRepository,
    private val passwordEncoder: PasswordEncoder,
) : ReactiveUserDetailsService {

    suspend fun findById(id: String): Account {
        return repository.findById(id.toUUID()) ?: throw ApiException.AccountNotFoundException("User not found!")
    }

    suspend fun register(body: RegisterAccount): String {
        if (repository.existsAccountByEmail(body.email)) throw RegisterAccountException("This email already in use!")
        val account = Account(
            email = body.email,
            username = body.username,
            password = passwordEncoder.encode(body.password)
        )
        return repository.save(account).email
    }

    fun isPasswordMatches(password: String, encodedPassword: String): Boolean {
        return passwordEncoder.matches(password, encodedPassword)
    }

    override fun findByUsername(username: String): Mono<UserDetails> {
        return mono { repository.findByEmail(username) }
    }


}