package com.arifwidayana.challengechapter4.di

import android.content.Context
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasourceImpl
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasource
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasourceImpl
import com.arifwidayana.challengechapter4.data.model.dao.StocksDao
import com.arifwidayana.challengechapter4.data.model.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {
    @Provides
    @Singleton
    fun provideLocalDatasource(
        userDao: UserDao,
        stocksDao: StocksDao
    ): LocalDatasource {
        return LocalDatasourceImpl(userDao, stocksDao)
    }

    @Provides
    @Singleton
    fun provideUserPreferenceDatasource(@ApplicationContext context: Context): UserPreferenceDatasource {
        return UserPreferenceDatasourceImpl(context)
    }
}