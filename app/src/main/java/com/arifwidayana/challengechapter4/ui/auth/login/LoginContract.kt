package com.arifwidayana.challengechapter4.ui.auth.login

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.request.LoginRequest
import kotlinx.coroutines.flow.StateFlow

interface LoginContract {
    fun loginUser(loginRequest: LoginRequest)
    val loginResult: StateFlow<Resource<Unit>>
}