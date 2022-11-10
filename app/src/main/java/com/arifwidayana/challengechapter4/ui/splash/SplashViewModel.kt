package com.arifwidayana.challengechapter4.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.repository.SplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val splashRepository: SplashRepository
): SplashContract, ViewModel() {
    private val _boardingPrefResult = MutableStateFlow<Resource<Boolean>>(Resource.Empty())
    private val _usernamePrefResult = MutableStateFlow<Resource<String>>(Resource.Empty())
    override val boardingPrefResult: StateFlow<Resource<Boolean>> = _boardingPrefResult
    override val usernamePrefResult: StateFlow<Resource<String>> = _usernamePrefResult

    override fun boardingPref() {
        viewModelScope.launch {
            splashRepository.getBoarding().collect {
                _boardingPrefResult.value = Resource.Success(it.data)
            }
        }
    }

    override fun usernamePref() {
        viewModelScope.launch {
            splashRepository.getUsername().collect {
                _usernamePrefResult.value = Resource.Success(it.data)
            }
        }
    }
}