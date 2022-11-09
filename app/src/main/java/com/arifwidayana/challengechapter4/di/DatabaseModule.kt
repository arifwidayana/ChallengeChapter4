package com.arifwidayana.challengechapter4.di

import android.content.Context
import androidx.room.Room
import com.arifwidayana.challengechapter4.data.StocksDatabase
import com.arifwidayana.challengechapter4.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): StocksDatabase = Room.databaseBuilder(
        context,
        StocksDatabase::class.java,
        Constant.STOCK_DB
    ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideUserDao(stocksDatabase: StocksDatabase) = stocksDatabase.userDao()

    @Singleton
    @Provides
    fun provideStocksDao(stocksDatabase: StocksDatabase) = stocksDatabase.stocksDao()
}