package com.arifwidayana.challengechapter4.data.repository

import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseRepository
import com.arifwidayana.challengechapter4.data.datasource.LocalDatasource
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface RegisterRepository {
    fun registerUser(userEntity: UserEntity): Flow<Resource<Unit>>
    fun getUser(username: String): Flow<Resource<UserEntity?>>
}

class RegisterRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource
): RegisterRepository, BaseRepository() {
    override fun registerUser(userEntity: UserEntity): Flow<Resource<Unit>> = flow {
        emit(proceed { localDatasource.insertUser(userEntity) })
    }

    override fun getUser(username: String): Flow<Resource<UserEntity?>> = flow {
        emit(proceed { localDatasource.getUser(username).first() })
    }
}