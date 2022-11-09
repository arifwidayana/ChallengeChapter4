package com.arifwidayana.challengechapter4.di

import com.arifwidayana.challengechapter4.common.base.BaseGenericViewModel
import com.arifwidayana.challengechapter4.data.repository.LoginRepository
import com.arifwidayana.challengechapter4.ui.auth.login.LoginViewModel
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
    fun provideLoginViewModel(loginRepository: LoginRepository): LoginViewModel {
        return BaseGenericViewModel(LoginViewModel(loginRepository)).create(
            LoginViewModel::class.java
        )
    }
}