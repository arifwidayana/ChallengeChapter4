package com.arifwidayana.challengechapter4.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.repository.OnBoardingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository
): OnBoardingContract, ViewModel() {
    private val _boardingPrefResult = MutableStateFlow<Resource<Boolean>>(Resource.Empty())
    override val boardingPrefResult: StateFlow<Resource<Boolean>> = _boardingPrefResult

    override fun boardingPref() {
        viewModelScope.launch {
            onBoardingRepository.setBoardingPref(true).collect {
                _boardingPrefResult.value = Resource.Success()
            }
        }
    }
}