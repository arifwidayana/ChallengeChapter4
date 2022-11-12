package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AddStocksRepository {
    fun addStocks(stocksEntity: StocksEntity): Flow<Resource<Unit>>
}

class AddStocksRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
): AddStocksRepository, BaseRepository() {
    override fun addStocks(stocksEntity: StocksEntity): Flow<Resource<Unit>> = flow {
        emit(proceed { localDatasource.insertStocks(stocksEntity) })
    }
}