package com.karumi.assingnment.login

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.karumi.assingnment.login.repository.LoginRepository
import com.karumi.assingnment.login.service.LoginService

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * It's an instrumented test because LoginRepository depends on app context to store the token.
 * It could have used other approaches, but that's what I decided for persisting a simple value
 */
@RunWith(AndroidJUnit4::class)
class LoginRepositoryUnitTest {
    companion object {
        private const val TOKEN = "whatever"
    }

    @Test
    fun token_is_persisted_and_removed() {
        val loginRepository = LoginRepository(InstrumentationRegistry.getInstrumentation().targetContext)
        loginRepository.persistToken(TOKEN)
        assertEquals(loginRepository.retrieveToken(), TOKEN)
        loginRepository.removeToken()
        assertEquals(loginRepository.retrieveToken(), null)
    }
}