package com.karumi.assingnment.login

import com.karumi.assingnment.login.service.LoginService

class LoginPresenter(private val loginService: LoginService, private val view: View) {
    fun onLoginButtonClick(user: String, password: String) {
        if (loginService.login(user, password)) view.hideLoginForm()
    }

    interface View {
        fun hideLoginForm()
    }
}
