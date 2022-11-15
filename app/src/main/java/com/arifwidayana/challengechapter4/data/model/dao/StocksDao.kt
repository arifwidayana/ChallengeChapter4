package com.arifwidayana.challengechapter4.data.model.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.utils.Constant
import kotlinx.coroutines.flow.Flow

@Dao
interface StocksDao {
    @Query(Constant.GET_STOCKS)
    fun getStocks(username: String): Flow<List<StocksEntity?>>

    @Query(Constant.GET_STOCKS_BY_ID)
    fun getStocksById(idStocks: Int): Flow<StocksEntity?>

    @Insert(onConflict = REPLACE)
    suspend fun insertStocks(stocks: StocksEntity?)

    @Update
    suspend fun updateStocks(stocks: StocksEntity?)

    @Query(Constant.DELETE_STOCKS)
    suspend fun deleteStocks(idStocks: Int)
}