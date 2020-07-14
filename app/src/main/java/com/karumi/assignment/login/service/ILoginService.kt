package com.karumi.assignment.login.service

interface ILoginService {
    fun login(user: String, password: String): String
    fun logout(): Boolean
}
