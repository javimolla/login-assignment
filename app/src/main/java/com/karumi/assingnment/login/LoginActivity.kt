package com.karumi.assingnment.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karumi.assingnment.login.repository.LoginRepository
import com.karumi.assingnment.login.service.LoginService
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginPresenter.View {
    private val presenter = LoginPresenter(LoginService(LoginRepository(this)), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        loginButton.setOnClickListener {
            presenter.onLoginButtonClick(
                usernameText.text!!.toString(),
                passwordText.text!!.toString()
            )
        }
    }

    override fun hideLoginForm() {
        finish()
    }
}