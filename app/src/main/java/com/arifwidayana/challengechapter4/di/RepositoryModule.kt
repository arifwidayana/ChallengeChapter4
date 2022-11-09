package com.arifwidayana.challengechapter4.di

import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.repository.LoginRepository
import com.arifwidayana.challengechapter4.data.repository.LoginRepositoryImpl
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
    fun provideLoginRepository(localDatasource: LocalDatasource): LoginRepository {
        return LoginRepositoryImpl(localDatasource)
    }
}