package com.arifwidayana.challengechapter4.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arifwidayana.challengechapter4.model.dao.StocksDao
import com.arifwidayana.challengechapter4.model.dao.UserDao
import com.arifwidayana.challengechapter4.model.database.StocksEntity
import com.arifwidayana.challengechapter4.model.database.UserEntity

@Database (entities = [UserEntity::class, StocksEntity::class], version = 1)
abstract class StocksDatabase : RoomDatabase() {
    abstract fun stocksDao(): StocksDao
    abstract fun userDao(): UserDao

    companion object {
        private var userDatabase: StocksDatabase? = null
        private var stocksDatabase: StocksDatabase? = null

        fun getDataUser(context: Context): StocksDatabase? {
            if (userDatabase == null) {
                synchronized(StocksDatabase::class.java){
                    userDatabase = Room.databaseBuilder(context.applicationContext, StocksDatabase::class.java, "User.db").build()
                }
            }
            return userDatabase
        }

        fun getDataStocks(context: Context): StocksDatabase? {
            if (stocksDatabase == null) {
                synchronized(StocksDatabase::class.java){
                    stocksDatabase = Room.databaseBuilder(context.applicationContext, StocksDatabase::class.java, "Stocks.db").build()
                }
            }
            return stocksDatabase
        }
    }
}