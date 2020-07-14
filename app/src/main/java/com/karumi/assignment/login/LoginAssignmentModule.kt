package com.karumi.assignment.login

import com.karumi.assignment.login.repository.ILoginRepository
import com.karumi.assignment.login.repository.LoginRepositoryImpl
import com.karumi.assignment.login.service.ILoginService
import com.karumi.assignment.login.service.LoginServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class LoginAssignmentModule {
    @Singleton
    @Binds
    abstract fun bindLoginService(
        loginServiceImpl: LoginServiceImpl
    ): ILoginService

    @Singleton
    @Binds
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): ILoginRepository
}