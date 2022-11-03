package com.arifwidayana.challengechapter4.data.model.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.arifwidayana.challengechapter4.data.model.database.StocksEntity

@Dao
interface StocksDao {
    @Query("SELECT * FROM stock_table WHERE user_stock = :user")
    fun getDataStocks(user: String): List<StocksEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertDataStocks(stocks: StocksEntity): Long

    @Update
    suspend fun updateDataStocks(stocks: StocksEntity): Int

    @Delete
    suspend fun deleteDataStocks(stocks: StocksEntity): Int
}