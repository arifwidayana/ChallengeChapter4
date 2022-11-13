package com.arifwidayana.challengechapter4.ui.homepage.edit

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.request.EditStocksRequest
import kotlinx.coroutines.flow.StateFlow

interface EditStocksContract {
    val getStocksByIdResult: StateFlow<Resource<StocksEntity>>
    val updateStocksResult: StateFlow<Resource<Unit>>
    val deleteStocksResult: StateFlow<Resource<Unit>>
    fun getStocksById(idStocks: Int)
    fun updateStocks(editStocksRequest: EditStocksRequest)
    fun deleteStocks(idStocks: Int)
}