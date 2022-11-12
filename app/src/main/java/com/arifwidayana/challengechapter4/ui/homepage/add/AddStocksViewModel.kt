package com.arifwidayana.challengechapter4.ui.homepage.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.request.AddStocksRequest
import com.arifwidayana.challengechapter4.data.repository.AddStocksRepository
import com.arifwidayana.challengechapter4.data.repository.HomepageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStocksViewModel @Inject constructor(
    private val addStocksRepository: AddStocksRepository,
    private val homepageRepository: HomepageRepository
) : AddStocksContract, ViewModel() {
    private val _insertStocksResult = MutableStateFlow<Resource<Unit>>(Resource.Empty())
    override val insertStocksResult: StateFlow<Resource<Unit>> = _insertStocksResult

    override fun insertStocks(addStocksRequest: AddStocksRequest) {
        viewModelScope.launch {
            homepageRepository.getUsername().collect {
                homepageRepository.getUser(it.data.toString()).collect { source ->
                    addStocksRepository.addStocks(
                        StocksEntity(
                            id = null,
                            codeStock = addStocksRequest.codeStocks,
                            nameStock = addStocksRequest.nameStocks,
                            valueEquity = addStocksRequest.valueEquity,
                            valueNetProfit = addStocksRequest.valueNetProfit,
                            earningsPerShare = addStocksRequest.earningsPerShare,
                            priceBookValue = addStocksRequest.priceBookValue,
                            sharePrice = addStocksRequest.sharePrice,
                            shareStock = addStocksRequest.shareValue,
                            userStock = source.data?.username
                        )
                    ).collect {
                        _insertStocksResult.value = Resource.Success()
                    }
                }
            }
        }
    }
}