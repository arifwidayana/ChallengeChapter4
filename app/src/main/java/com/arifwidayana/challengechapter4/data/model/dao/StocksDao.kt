package com.arifwidayana.challengechapter4.data.model.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StocksDao {
    @Query("SELECT * FROM stock_table WHERE user_stock = :username")
    fun getStocks(username: String): Flow<List<StocksEntity?>>

    @Query("SELECT * FROM stock_table WHERE id = :idStocks")
    fun getStocksById(idStocks: Int): Flow<StocksEntity?>

    @Insert(onConflict = REPLACE)
    suspend fun insertStocks(stocks: StocksEntity?)

    @Update
    suspend fun updateStocks(stocks: StocksEntity?)

    @Query("DELETE FROM stock_table WHERE id = :idStocks")
    suspend fun deleteStocks(idStocks: Int)
}