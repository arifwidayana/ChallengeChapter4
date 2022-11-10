package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface OnBoardingRepository {
    suspend fun setBoardingPref(status: Boolean): Flow<Resource<Unit>>
}

class OnBoardingRepositoryImpl @Inject constructor(
    private val userPreferenceDatasource: UserPreferenceDatasource
): OnBoardingRepository, BaseRepository() {
    override suspend fun setBoardingPref(status: Boolean): Flow<Resource<Unit>> = flow {
        emit(proceed { userPreferenceDatasource.setBoarding(status) })
    }
}