package com.karumi.assingnment.login

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Use an instrumented test because LoginService depends on app context to store the token
 * It could have used other approaches, but that's what I decided for persisting a simple value
 */
@RunWith(AndroidJUnit4::class)
class LoginServiceUnitTest {
    @Test
    fun user_logs_in_and_out() {
        val loginService = LoginService(InstrumentationRegistry.getInstrumentation().targetContext)
        loginService.login("whatever", "itdoesnotmatter")
        assertNotNull(loginService.getToken())
        loginService.logout()
        assertNull(loginService.getToken())
    }
}