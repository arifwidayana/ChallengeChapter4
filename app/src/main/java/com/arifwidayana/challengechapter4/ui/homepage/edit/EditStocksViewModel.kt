package com.arifwidayana.challengechapter4.ui.homepage.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.request.EditStocksRequest
import com.arifwidayana.challengechapter4.data.repository.EditStocksRepository
import com.arifwidayana.challengechapter4.data.repository.HomepageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditStocksViewModel @Inject constructor(
    private val editStocksRepository: EditStocksRepository,
    private val homepageRepository: HomepageRepository
): EditStocksContract, ViewModel() {
    private val _getStocksByIdResult = MutableStateFlow<Resource<StocksEntity>>(Resource.Empty())
    private val _updateStocksResult = MutableStateFlow<Resource<Unit>>(Resource.Empty())
    private val _deleteStocksResult = MutableStateFlow<Resource<Unit>>(Resource.Empty())
    override val getStocksByIdResult: StateFlow<Resource<StocksEntity>> = _getStocksByIdResult
    override val updateStocksResult: StateFlow<Resource<Unit>> = _updateStocksResult
    override val deleteStocksResult: StateFlow<Resource<Unit>> = _deleteStocksResult

    override fun getStocksById(idStocks: Int) {
        viewModelScope.launch {
            editStocksRepository.getStocksById(idStocks).collect {
                _getStocksByIdResult.value = Resource.Success(it.data)
            }
        }
    }

    override fun updateStocks(editStocksRequest: EditStocksRequest) {
        viewModelScope.launch {
            homepageRepository.getUsername().collect {
                homepageRepository.getUser(it.data.toString()).collect { source ->
                    editStocksRepository.updateStocks(StocksEntity(
                        id = editStocksRequest.id,
                        codeStock = editStocksRequest.codeStocks,
                        nameStock = editStocksRequest.nameStocks,
                        valueEquity = editStocksRequest.valueEquity,
                        valueNetProfit = editStocksRequest.valueNetProfit,
                        earningsPerShare = editStocksRequest.earningsPerShare,
                        priceBookValue = editStocksRequest.priceBookValue,
                        sharePrice = editStocksRequest.sharePrice,
                        shareStock = editStocksRequest.shareValue,
                        userStock = source.data?.username
                    )).collect {
                        _updateStocksResult.value = Resource.Success(message = "Stocks data success to updated")
                    }
                }
            }
        }
    }

    override fun deleteStocks(idStocks: Int) {
        viewModelScope.launch {
            editStocksRepository.deleteStocks(idStocks).collect {
                _deleteStocksResult.value = Resource.Success(message = "Stocks has been deleted")
            }
        }
    }
}