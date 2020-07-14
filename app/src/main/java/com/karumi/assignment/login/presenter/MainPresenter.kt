package com.karumi.assignment.login.presenter

import com.karumi.assignment.login.model.UserModel
import javax.inject.Inject

class MainPresenter @Inject constructor(private val userModel: UserModel) {
    private var view: View? = null

    fun setView(view: View?) {
        this.view = view
    }

    fun onDestroy() {
        this.view = null
    }

    fun onLogoutButtonClick() {
        if (userModel.logout()) view?.showLoginForm()
    }

    fun checkIfUserIsLogged() {
        if (!userModel.isLoggedIn()) view?.showLoginForm()
    }

    interface View {
        fun showLoginForm()
    }
}
