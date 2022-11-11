package com.arifwidayana.challengechapter4.ui.homepage

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import kotlinx.coroutines.flow.StateFlow

interface HomepageContract {
    val getUserResult: StateFlow<Resource<UserEntity>>
    val getStocksResult: StateFlow<Resource<List<StocksEntity?>>>
    fun getUser()
    fun getStocks()
    fun logoutUser()
}