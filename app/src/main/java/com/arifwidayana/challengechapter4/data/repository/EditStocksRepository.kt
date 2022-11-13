package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface EditStocksRepository {
    fun getStocksById(idStocks: Int): Flow<Resource<StocksEntity?>>
    fun updateStocks(stocksEntity: StocksEntity): Flow<Resource<Unit>>
    fun deleteStocks(idStocks: Int): Flow<Resource<Unit>>
}

class EditStocksRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource
) : EditStocksRepository, BaseRepository(){
    override fun getStocksById(idStocks: Int): Flow<Resource<StocksEntity?>> = flow {
        emit(proceed { localDatasource.getStocksById(idStocks).first() })
    }

    override fun updateStocks(stocksEntity: StocksEntity): Flow<Resource<Unit>> = flow {
        emit(proceed { localDatasource.updateStocks(stocksEntity) })
    }

    override fun deleteStocks(idStocks: Int): Flow<Resource<Unit>> = flow {
        emit(proceed { localDatasource.deleteStocks(idStocks) })
    }
}