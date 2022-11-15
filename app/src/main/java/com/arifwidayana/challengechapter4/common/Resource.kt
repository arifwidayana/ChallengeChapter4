package com.arifwidayana.challengechapter4.common

import java.lang.Exception

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val exception: Exception? = null
) {
    class Success<T>(data: T? = null, message: String? = null): Resource<T>(data, message)
    class Empty<T>(data: T? = null): Resource<T>(data)
    class Error<T>(exception: Exception? = null, data: T? = null, message: String? = null): Resource<T>(data, exception = exception, message = message)
}