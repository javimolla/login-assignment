package com.karumi.assingnment.login.service

import com.karumi.assingnment.login.repository.LoginRepository

/**
 * Login API service class that simply persist a token string
 */
class LoginService(private val loginRepository: LoginRepository) {
    companion object {
        private const val TOKEN_PREF_VALUE = "token"
    }

    // We don't need to check the passed values, that's why I put this suppress
    @Suppress("UNUSED_PARAMETER")
    fun login(user: String, password: String): Boolean {
        loginRepository.persistToken(TOKEN_PREF_VALUE)
        return isLoggedIn()
    }

    fun logout(): Boolean {
        loginRepository.removeToken()
        return !isLoggedIn()
    }

    fun isLoggedIn():Boolean {
        return loginRepository.retrieveToken() != null
    }
}