package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasource
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import com.arifwidayana.challengechapter4.data.model.request.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface LoginRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Flow<Resource<UserEntity?>>
    suspend fun setUsernamePref(username: String): Flow<Resource<Unit>>
}

class LoginRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val userPreferenceDatasource: UserPreferenceDatasource
): LoginRepository, BaseRepository() {
    override suspend fun loginUser(loginRequest: LoginRequest): Flow<Resource<UserEntity?>> = flow {
        emit(proceed { localDatasource.loginUser(loginRequest).first() })
    }

    override suspend fun setUsernamePref(username: String): Flow<Resource<Unit>> = flow {
        emit(proceed { userPreferenceDatasource.setUsername(username) })
    }
}