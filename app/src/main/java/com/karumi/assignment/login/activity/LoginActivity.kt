package com.karumi.assignment.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.karumi.assignment.login.R
import com.karumi.assignment.login.presenter.LoginPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), LoginPresenter.View {
    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        presenter.setView(this)
        loginButton.setOnClickListener {
            presenter.onLoginButtonClick(
                usernameText.text!!.toString(),
                passwordText.text!!.toString()
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun hideLoginForm() {
        finish()
    }
}