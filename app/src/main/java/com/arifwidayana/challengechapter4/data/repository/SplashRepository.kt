package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface SplashRepository {
    suspend fun getBoarding(): Flow<Resource<Boolean>>
    suspend fun getUsername(): Flow<Resource<String>>
}

class SplashRepositoryImpl @Inject constructor(
    private val userPreferenceDatasource: UserPreferenceDatasource
): SplashRepository, BaseRepository() {
    override suspend fun getBoarding(): Flow<Resource<Boolean>> = flow {
        emit(proceed { userPreferenceDatasource.getBoarding().first() })
    }

    override suspend fun getUsername(): Flow<Resource<String>> = flow {
        emit(proceed { userPreferenceDatasource.getUsername().first() })
    }
}