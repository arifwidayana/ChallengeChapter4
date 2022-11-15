package com.arifwidayana.challengechapter4.ui.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import com.arifwidayana.challengechapter4.data.model.request.RegisterRequest
import com.arifwidayana.challengechapter4.data.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerRepository: RegisterRepository
): RegisterContract, ViewModel() {
    private val _registerResult = MutableStateFlow<Resource<Unit>>(Resource.Empty())
    override val registerResult: StateFlow<Resource<Unit>> = _registerResult

    override fun registerUser(registerRequest: RegisterRequest) {
        try {
            viewModelScope.launch {
                registerRepository.getUser(registerRequest.username).collect {
                    when (it.data?.username) {
                        registerRequest.username -> {
                            _registerResult.value = Resource.Error(message = "Username has been taken, try another")
                        }
                        else -> {
                            registerRepository.registerUser(
                                UserEntity(
                                    id = null,
                                    name = registerRequest.name,
                                    username = registerRequest.username,
                                    password = registerRequest.password
                                )
                            ).collect {
                                _registerResult.value = Resource.Success(message = "Account created success")
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            _registerResult.value = Resource.Error(message = e.message.orEmpty())
        }
    }
}