package com.arifwidayana.challengechapter4.model.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.arifwidayana.challengechapter4.model.database.StocksEntity

@Dao
interface StocksDao {
//    @Query("SELECT * FROM Stocks")
//    fun getDataStocks(): List<StocksEntity>

    @Insert(onConflict = REPLACE)
    fun insertDataStocks(stocks: StocksEntity): Long

    @Update
    fun updateDataStocks(stocks: StocksEntity): Int

    @Delete
    fun deleteDataStudent(stocks: StocksEntity): Int
}