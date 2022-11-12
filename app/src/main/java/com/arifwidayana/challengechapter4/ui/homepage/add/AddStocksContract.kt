package com.arifwidayana.challengechapter4.ui.homepage.add

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.request.AddStocksRequest
import kotlinx.coroutines.flow.StateFlow

interface AddStocksContract {
    val insertStocksResult: StateFlow<Resource<Unit>>
    fun insertStocks(addStocksRequest: AddStocksRequest)
}