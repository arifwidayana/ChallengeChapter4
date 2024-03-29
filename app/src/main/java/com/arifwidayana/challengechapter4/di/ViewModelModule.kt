package com.arifwidayana.challengechapter4.di

import com.arifwidayana.challengechapter4.common.base.BaseGenericViewModel
import com.arifwidayana.challengechapter4.data.repository.*
import com.arifwidayana.challengechapter4.ui.auth.login.LoginViewModel
import com.arifwidayana.challengechapter4.ui.auth.register.RegisterViewModel
import com.arifwidayana.challengechapter4.ui.homepage.HomepageViewModel
import com.arifwidayana.challengechapter4.ui.homepage.add.AddStocksViewModel
import com.arifwidayana.challengechapter4.ui.homepage.edit.EditStocksViewModel
import com.arifwidayana.challengechapter4.ui.onboarding.OnBoardingViewModel
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
    fun provideOnBoardingViewModel(onBoardingRepository: OnBoardingRepository): OnBoardingViewModel {
        return BaseGenericViewModel(OnBoardingViewModel(onBoardingRepository)).create(
            OnBoardingViewModel::class.java
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

    @Provides
    @FragmentScoped
    fun provideHomepageViewModel(homepageRepository: HomepageRepository): HomepageViewModel {
        return BaseGenericViewModel(HomepageViewModel(homepageRepository)).create(
            HomepageViewModel::class.java
        )
    }

    @Provides
    @FragmentScoped
    fun provideAddStocksViewModel(addStocksRepository: AddStocksRepository, homepageRepository: HomepageRepository): AddStocksViewModel {
        return BaseGenericViewModel(AddStocksViewModel(addStocksRepository, homepageRepository)).create(
            AddStocksViewModel::class.java
        )
    }

    @Provides
    @FragmentScoped
    fun provideEditStocksViewModel(editStocksRepository: EditStocksRepository, homepageRepository: HomepageRepository): EditStocksViewModel {
        return BaseGenericViewModel(EditStocksViewModel(editStocksRepository, homepageRepository)).create(
            EditStocksViewModel::class.java
        )
    }
}