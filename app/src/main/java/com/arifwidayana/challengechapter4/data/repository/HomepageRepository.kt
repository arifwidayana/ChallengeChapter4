package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.datasource.UserPreferenceDatasource
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface HomepageRepository {
    fun getUsername(): Flow<Resource<String>>
    fun getUser(username: String): Flow<Resource<UserEntity?>>
    fun getStocks(username: String): Flow<Resource<List<StocksEntity?>>>
    fun logoutUser(): Flow<Resource<Unit>>
}

class HomepageRepositoryImpl @Inject constructor(
    private val userPreferenceDatasource: UserPreferenceDatasource,
    private val localDatasource: LocalDatasource
): HomepageRepository, BaseRepository() {
    override fun getUsername(): Flow<Resource<String>> = flow {
        emit(proceed { userPreferenceDatasource.getUsername().first() })
    }

    override fun getUser(username: String): Flow<Resource<UserEntity?>> = flow {
        emit(proceed { localDatasource.getUser(username).first() })
    }

    override fun getStocks(username: String): Flow<Resource<List<StocksEntity?>>> = flow {
        emit(proceed { localDatasource.getStocks(username).first() })
    }

    override fun logoutUser(): Flow<Resource<Unit>> = flow {
        emit(proceed { userPreferenceDatasource.logoutUser() })
    }
}