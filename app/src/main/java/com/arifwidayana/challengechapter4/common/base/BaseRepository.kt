package com.arifwidayana.challengechapter4.common.base

import com.arifwidayana.challengechapter4.common.Resource

abstract class BaseRepository {
    suspend fun <T> proceed(coroutine: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(coroutine.invoke())
        } catch (exception: Exception) {
            Resource.Error(exception)
        }
    }
}