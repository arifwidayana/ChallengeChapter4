package com.arifwidayana.challengechapter4.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arifwidayana.challengechapter4.data.model.dao.StocksDao
import com.arifwidayana.challengechapter4.data.model.dao.UserDao
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity

@Database(entities = [UserEntity::class, StocksEntity::class], version = 1, exportSchema = false)
abstract class StocksDatabase : RoomDatabase() {
    abstract fun stocksDao(): StocksDao
    abstract fun userDao(): UserDao
}