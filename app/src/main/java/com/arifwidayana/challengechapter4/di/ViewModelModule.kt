package com.arifwidayana.challengechapter4.di

import com.arifwidayana.challengechapter4.common.base.BaseGenericViewModel
import com.arifwidayana.challengechapter4.data.repository.LoginRepository
import com.arifwidayana.challengechapter4.data.repository.RegisterRepository
import com.arifwidayana.challengechapter4.data.repository.SplashRepository
import com.arifwidayana.challengechapter4.ui.auth.login.LoginViewModel
import com.arifwidayana.challengechapter4.ui.auth.register.RegisterViewModel
import com.arifwidayana.challengechapter4.ui.splash.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object ViewModelModule {
    @Provides
    @FragmentScoped
    fun provideSplashViewModel(splashRepository: SplashRepository): SplashViewModel {
        return BaseGenericViewModel(SplashViewModel(splashRepository)).create(
            SplashViewModel::class.java
        )
    }

    @Provides
    @FragmentScoped
    fun provideLoginViewModel(loginRepository: LoginRepository): LoginViewModel {
        return BaseGenericViewModel(LoginViewModel(loginRepository)).create(
            LoginViewModel::class.java
        )
    }

    @Provides
    @FragmentScoped
    fun provideRegisterViewModel(registerRepository: RegisterRepository): RegisterViewModel {
        return BaseGenericViewModel(RegisterViewModel(registerRepository)).create(
            RegisterViewModel::class.java
        )
    }
}