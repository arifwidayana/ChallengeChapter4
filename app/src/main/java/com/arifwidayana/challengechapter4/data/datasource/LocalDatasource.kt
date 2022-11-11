package com.arifwidayana.challengechapter4.data.datasource

import com.arifwidayana.challengechapter4.data.model.dao.StocksDao
import com.arifwidayana.challengechapter4.data.model.dao.UserDao
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import com.arifwidayana.challengechapter4.data.model.request.LoginRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocalDatasource {
    suspend fun insertUser(userEntity: UserEntity)
    suspend fun loginUser(loginRequest: LoginRequest): Flow<UserEntity?>
    suspend fun getUser(username: String): Flow<UserEntity?>
    suspend fun getStocks(username: String): Flow<List<StocksEntity>>
    suspend fun insertStocks(stocksEntity: StocksEntity)
    suspend fun updateStocks(stocksEntity: StocksEntity)
    suspend fun deleteStocks(id: Int)
}

class LocalDatasourceImpl @Inject constructor(
    private val userDao: UserDao,
    private val stocksDao: StocksDao
) : LocalDatasource {
    override suspend fun insertUser(userEntity: UserEntity) {
        return userDao.insertUser(userEntity)
    }

    override suspend fun loginUser(loginRequest: LoginRequest): Flow<UserEntity?> {
        return userDao.loginUser(
            username = loginRequest.username,
            password = loginRequest.password
        )
    }

    override suspend fun getUser(username: String): Flow<UserEntity?> {
        return userDao.getUser(username)
    }

    override suspend fun getStocks(username: String): Flow<List<StocksEntity>> {
        return stocksDao.getStocks(username)
    }

    override suspend fun insertStocks(stocksEntity: StocksEntity) {
        return stocksDao.insertStocks(stocksEntity)
    }

    override suspend fun updateStocks(stocksEntity: StocksEntity) {
        return stocksDao.updateStocks(stocksEntity)
    }

    override suspend fun deleteStocks(id: Int) {
        return stocksDao.deleteStocks(id)
    }
}