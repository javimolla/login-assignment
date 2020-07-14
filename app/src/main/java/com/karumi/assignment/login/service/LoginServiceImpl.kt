package com.karumi.assignment.login.service

import javax.inject.Inject

/**
 * Simple implementation of login service class that connects to an API
 */
class LoginServiceImpl @Inject constructor() : ILoginService {
    companion object {
        private const val TOKEN_VALUE = "token"
    }

    override fun login(user: String, password: String): String {
        return TOKEN_VALUE
    }

    override fun logout(): Boolean {
        return true
    }
}