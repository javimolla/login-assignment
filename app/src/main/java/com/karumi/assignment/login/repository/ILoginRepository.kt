package com.karumi.assignment.login.repository

/**
 * Basic interface for storing the user token
 */
interface ILoginRepository {
    fun persistToken(token: String?)
    fun retrieveToken(): String?
    fun removeToken()
}
