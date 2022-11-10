package com.arifwidayana.challengechapter4.ui.splash

import com.arifwidayana.challengechapter4.common.Resource
import kotlinx.coroutines.flow.StateFlow

interface SplashContract {
    val boardingPrefResult: StateFlow<Resource<Boolean>>
    val usernamePrefResult: StateFlow<Resource<String>>
    fun boardingPref()
    fun usernamePref()
}