package com.karumi.assignment.login

import com.karumi.assignment.login.repository.LoginRepository
import com.karumi.assignment.login.service.LoginService

class LoginPresenter(private val loginRepository: LoginRepository, private val view: View) {
    private val loginService = LoginService(loginRepository)

    fun onLoginButtonClick(user: String, password: String) {
        if (loginService.login(user, password)) view.hideLoginForm()
    }

    interface View {
        fun hideLoginForm()
    }
}
