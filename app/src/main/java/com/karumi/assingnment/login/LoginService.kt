package com.karumi.assingnment.login

import android.content.Context

class LoginService(private val context: Context) {
    companion object {
        private const val SHARED_PREFS_FILE = "com.karumi.assingnment.login.prefs"
        private const val TOKEN_PREF_KEY = "token"
        private const val TOKEN_PREF_VALUE = "token"
    }

    // We don't need to check the passed values, that's why I put this suppress
    @Suppress("UNUSED_PARAMETER")
    fun login(user: String, password: String) {
        persistToken(TOKEN_PREF_VALUE)
    }

    fun logout() {
        persistToken(null)
    }

    fun getToken(): String? {
        return context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE)
            .getString(TOKEN_PREF_KEY, null)
    }

    private fun persistToken(token: String?) {
        context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE).edit()
            .putString(TOKEN_PREF_KEY, token).apply()
    }
}