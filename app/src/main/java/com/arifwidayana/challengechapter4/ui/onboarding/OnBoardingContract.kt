package com.arifwidayana.challengechapter4.ui.onboarding

import com.arifwidayana.challengechapter4.common.Resource
import kotlinx.coroutines.flow.StateFlow

interface OnBoardingContract {
    val boardingPrefResult: StateFlow<Resource<Boolean>>
    fun boardingPref()
}