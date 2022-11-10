package com.arifwidayana.challengechapter4.ui.auth.register

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.request.RegisterRequest
import kotlinx.coroutines.flow.StateFlow

interface RegisterContract {
    val registerResult: StateFlow<Resource<Unit>>
    fun registerUser(registerRequest: RegisterRequest)
}