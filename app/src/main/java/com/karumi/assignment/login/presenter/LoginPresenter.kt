package com.karumi.assignment.login.presenter

import com.karumi.assignment.login.model.UserModel
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userModel: UserModel) {
    private var view: View? = null

    fun setView(view: View?) {
        this.view = view
    }

    fun onDestroy() {
        this.view = null
    }

    fun onLoginButtonClick(user: String, password: String) {
        if (userModel.login(user, password)) view?.hideLoginForm()
    }

    interface View {
        fun hideLoginForm()
    }
}
