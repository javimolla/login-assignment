package com.karumi.assignment.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.karumi.assignment.login.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityUnitTest {
    @get:Rule
    val activityRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun activity_pressing_login_button_persists_token() {
        val loginRepository = LoginRepository(activityRule.activity)
        loginRepository.removeToken()
        assertNull(loginRepository.retrieveToken())
        activityRule.activity.runOnUiThread {
            activityRule.activity.loginButton.performClick()
            assertNotNull(loginRepository.retrieveToken())
        }
    }
}
