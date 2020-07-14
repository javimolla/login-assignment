package com.karumi.assignment.login.model

import com.karumi.assignment.login.repository.ILoginRepository
import com.karumi.assignment.login.service.ILoginService
import javax.inject.Inject

class UserModel @Inject constructor(
    private val loginRepository: ILoginRepository,
    private val loginService: ILoginService
) {
    fun login(user: String, password: String): Boolean {
        loginRepository.persistToken(loginService.login(user, password))
        return isLoggedIn()
    }

    fun logout(): Boolean {
        loginRepository.removeToken()
        return !isLoggedIn()
    }

    fun isLoggedIn(): Boolean {
        return loginRepository.retrieveToken() != null
    }
}