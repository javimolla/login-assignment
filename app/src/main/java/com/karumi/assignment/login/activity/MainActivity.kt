package com.karumi.assignment.login.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.karumi.assignment.login.R
import com.karumi.assignment.login.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),
    MainPresenter.View {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        logoutButton.setOnClickListener { presenter.onLogoutButtonClick() }
    }

    override fun onResume() {
        super.onResume()
        presenter.checkIfUserIsLogged()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showLoginForm() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}