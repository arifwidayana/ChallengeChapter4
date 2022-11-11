package com.arifwidayana.challengechapter4.ui.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import com.arifwidayana.challengechapter4.data.repository.HomepageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val homepageRepository: HomepageRepository
): HomepageContract, ViewModel() {
    private val _getUserResult = MutableStateFlow<Resource<UserEntity>>(Resource.Empty())
    private val _getStocksResult = MutableStateFlow<Resource<List<StocksEntity?>>>(Resource.Empty())
    override val getUserResult: StateFlow<Resource<UserEntity>> = _getUserResult
    override val getStocksResult: StateFlow<Resource<List<StocksEntity?>>> = _getStocksResult

    override fun getUser() {
        viewModelScope.launch {
            homepageRepository.getUsername().collect {
                homepageRepository.getUser(it.data.toString()).collect { source ->
                    _getUserResult.value = Resource.Success(source.data)
                }
            }
        }
    }

    override fun getStocks() {
        viewModelScope.launch {
            homepageRepository.getUsername().collect {
                homepageRepository.getStocks(it.data.toString()).collect { source ->
                    _getStocksResult.value = Resource.Success(source.data)
                }
            }
        }
    }

    override fun logoutUser() {
        viewModelScope.launch {
            homepageRepository.logoutUser().first()
        }
    }
}