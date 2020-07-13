package com.karumi.assignment.login

import com.karumi.assignment.login.service.LoginService

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
