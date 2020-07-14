package com.karumi.assignment.login.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Login repository that stores the token in the shared preferences instead of a room database
 * for simplicity
 */
class LoginRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ILoginRepository {
    companion object {
        private const val SHARED_PREFS_FILE = "com.karumi.assignment.login.prefs"
        private const val TOKEN_PREF_KEY = "token"
    }

    override fun persistToken(token: String?) {
        context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE).edit()
            .putString(TOKEN_PREF_KEY, token).apply()
    }

    override fun retrieveToken(): String? {
        return context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
            .getString(TOKEN_PREF_KEY, null)
    }

    override fun removeToken() {
        persistToken(null)
    }
}
