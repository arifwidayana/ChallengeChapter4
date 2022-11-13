package com.arifwidayana.challengechapter4.di

import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasource
import com.arifwidayana.challengechapter4.data.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideSplashRepository(userPreferenceDatasource: UserPreferenceDatasource): SplashRepository {
        return SplashRepositoryImpl(userPreferenceDatasource)
    }

    @Provides
    @Singleton
    fun provideOnBoardingRepository(userPreferenceDatasource: UserPreferenceDatasource): OnBoardingRepository {
        return OnBoardingRepositoryImpl(userPreferenceDatasource)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        localDatasource: LocalDatasource,
        userPreferenceDatasource: UserPreferenceDatasource
    ): LoginRepository {
        return LoginRepositoryImpl(localDatasource, userPreferenceDatasource)
    }

    @Provides
    @Singleton
    fun provideRegisterRepository(localDatasource: LocalDatasource): RegisterRepository {
        return RegisterRepositoryImpl(localDatasource)
    }

    @Provides
    @Singleton
    fun provideHomepageRepository(userPreferenceDatasource: UserPreferenceDatasource, localDatasource: LocalDatasource): HomepageRepository {
        return HomepageRepositoryImpl(userPreferenceDatasource, localDatasource)
    }

    @Provides
    @Singleton
    fun provideAddStocksRepository(localDatasource: LocalDatasource): AddStocksRepository {
        return AddStocksRepositoryImpl(localDatasource)
    }

    @Provides
    @Singleton
    fun provideEditStocksRepository(localDatasource: LocalDatasource): EditStocksRepository {
        return EditStocksRepositoryImpl (localDatasource)
    }
}