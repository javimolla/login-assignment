package com.karumi.assingnment.login

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.karumi.assingnment.login.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUnitTest {
    companion object {
        private const val TOKEN = "whatever"
    }

    @get:Rule
    val activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private lateinit var launchedActivity: MainActivity

    @Before
    fun setUp() {
        val intent = Intent(Intent.ACTION_PICK)
        //this is the key part
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        //this is the key part
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        launchedActivity = activityRule.launchActivity(intent)
    }

    @Test
    fun activity_pressing_logout_button_removes_token() {
        val loginRepository = LoginRepository(activityRule.activity)
        loginRepository.persistToken(TOKEN)
        assertEquals(TOKEN, loginRepository.retrieveToken())
        activityRule.activity.logoutButton.performClick()
        Thread.sleep(5000)
        assertNull(loginRepository.retrieveToken())
    }
}
