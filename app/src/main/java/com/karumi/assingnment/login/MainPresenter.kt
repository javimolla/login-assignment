package com.karumi.assingnment.login

import com.karumi.assingnment.login.service.LoginService

class MainPresenter(private val loginService: LoginService, private val view: View) {
    fun onLogoutButtonClick() {
        if (loginService.logout()) view.showLoginForm()
    }

    fun checkIfUserIsLogged() {
        if (!loginService.isLoggedIn()) view.showLoginForm()
    }

    interface View {
        fun showLoginForm()
    }
}