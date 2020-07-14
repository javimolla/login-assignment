package com.karumi.assignment.login

import androidx.test.rule.ActivityTestRule
import com.karumi.assignment.login.activity.MainActivity
import com.karumi.assignment.login.repository.ILoginRepository
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class MainActivityUnitTest : BaseUnitTest() {
    @Inject
    lateinit var loginRepository: ILoginRepository

    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun activity_pressing_logout_button_removes_token() {
        loginRepository.removeToken()
        assertNull(loginRepository.retrieveToken())
        activityRule.activity.runOnUiThread {
            activityRule.activity.logoutButton.performClick()
            assertNull(loginRepository.retrieveToken())
        }
    }
}
