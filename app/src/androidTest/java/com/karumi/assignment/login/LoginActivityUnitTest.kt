package com.karumi.assignment.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.karumi.assignment.login.activity.LoginActivity
import com.karumi.assignment.login.repository.ILoginRepository
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class LoginActivityUnitTest : BaseUnitTest() {
    @get:Rule
    val activityRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Inject
    lateinit var loginRepository: ILoginRepository

    @Test
    fun activity_pressing_login_button_persists_token() {
        loginRepository.removeToken()
        assertNull(loginRepository.retrieveToken())
        activityRule.activity.runOnUiThread {
            activityRule.activity.loginButton.performClick()
            assertNotNull(loginRepository.retrieveToken())
        }
    }
}
