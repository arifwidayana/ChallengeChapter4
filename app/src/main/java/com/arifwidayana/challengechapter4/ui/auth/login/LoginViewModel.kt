package com.arifwidayana.challengechapter4.ui.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.request.LoginRequest
import com.arifwidayana.challengechapter4.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : LoginContract, ViewModel() {
    private val _loginResult = MutableStateFlow<Resource<Unit>>(Resource.Empty())
    override val loginResult: StateFlow<Resource<Unit>> = _loginResult

    override fun loginUser(loginRequest: LoginRequest) {
        try {
            viewModelScope.launch {
                loginRepository.loginUser(loginRequest).collect {
                    when {
                        (it.data?.username == loginRequest.username) && (it.data.password == loginRequest.password) -> {
                            loginRepository.setUsernamePref(loginRequest.username).first()
                            _loginResult.value = Resource.Success()
                        }
                        else -> _loginResult.value = Resource.Error(message = "Username and password is wrong")
                    }
                }
            }
        } catch (e: Exception) {
            viewModelScope.launch {
                _loginResult.value = Resource.Error(message = e.message.orEmpty())
            }
        }
    }
}