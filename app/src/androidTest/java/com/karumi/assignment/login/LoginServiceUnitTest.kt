package com.karumi.assignment.login

import com.karumi.assignment.login.service.ILoginService
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import javax.inject.Inject

/**
 * Use an instrumented test because LoginRepository depends on app context to store the token.
 * It could have used other approaches, but that's what I decided for persisting a simple value
 */
@HiltAndroidTest
class LoginServiceUnitTest @Inject constructor(
    private val loginService: ILoginService
) {
    @Test
    fun user_logs_in_and_out() {
        assertNotNull(loginService.login("whatever", "itdoesnotmatter"))
        assertTrue(loginService.logout())
    }
}