package com.karumi.assignment.login.repository

import android.content.Context

/**
 * Login repository that stores the token in the shared preferences instead of a room database
 * for simplicity
 */
class LoginRepository(private val context: Context) {
    companion object {
        private const val SHARED_PREFS_FILE = "com.karumi.assignment.login.prefs"
        private const val TOKEN_PREF_KEY = "token"
    }

    fun persistToken(token: String?) {
        context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE).edit()
            .putString(TOKEN_PREF_KEY, token).apply()
    }

    fun retrieveToken(): String? {
        return context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
            .getString(TOKEN_PREF_KEY, null)
    }

    fun removeToken() {
        persistToken(null)
    }
}
