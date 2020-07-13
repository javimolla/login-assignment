package com.karumi.assignment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.karumi.assignment.login.repository.LoginRepository
import com.karumi.assignment.login.service.LoginService
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