package com.karumi.assignment.login

import com.karumi.assignment.login.repository.LoginRepository
import com.karumi.assignment.login.service.LoginService

class MainPresenter(loginRepository: LoginRepository, private val view: View) {
    private val loginService = LoginService(loginRepository)

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
