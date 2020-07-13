package com.karumi.assignment.login

import com.karumi.assignment.login.service.LoginService

class LoginPresenter(private val loginService: LoginService, private val view: View) {
    fun onLoginButtonClick(user: String, password: String) {
        if (loginService.login(user, password)) view.hideLoginForm()
    }

    interface View {
        fun hideLoginForm()
    }
}
