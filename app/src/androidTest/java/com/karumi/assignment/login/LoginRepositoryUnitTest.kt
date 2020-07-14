package com.karumi.assignment.login

import com.karumi.assignment.login.repository.ILoginRepository
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import javax.inject.Inject

/**
 * It's an instrumented test because LoginRepository depends on app context to store the token.
 * I could have used other approaches, but that's what I decided for persisting a simple value
 */
@HiltAndroidTest
class LoginRepositoryUnitTest : BaseUnitTest() {
    companion object {
        private const val TOKEN = "whatever"
    }

    @Inject
    lateinit var loginRepository: ILoginRepository

    @Test
    fun token_is_persisted_and_removed() {
        loginRepository.persistToken(TOKEN)
        assertEquals(loginRepository.retrieveToken(), TOKEN)
        loginRepository.removeToken()
        assertNull(loginRepository.retrieveToken())
    }
}