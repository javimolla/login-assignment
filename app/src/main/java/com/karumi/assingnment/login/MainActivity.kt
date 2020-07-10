package com.karumi.assingnment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karumi.assingnment.login.repository.LoginRepository
import com.karumi.assingnment.login.service.LoginService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {
    private val presenter = MainPresenter(LoginService(LoginRepository(this)), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logoutButton.setOnClickListener { presenter.onLogoutButtonClick() }
    }

    override fun onResume() {
        super.onResume()
        presenter.checkIfUserIsLogged()
    }

    override fun showLoginForm() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}