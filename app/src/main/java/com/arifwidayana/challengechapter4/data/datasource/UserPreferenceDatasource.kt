package com.arifwidayana.challengechapter4.data.datasource

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.arifwidayana.challengechapter4.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface UserPreferenceDatasource {
    suspend fun setBoarding(status: Boolean)
    suspend fun getBoarding(): Flow<Boolean>
    suspend fun setUsername(username: String)
    suspend fun getUsername(): Flow<String>
    suspend fun clearData()
}

class UserPreferenceDatasourceImpl @Inject constructor(
    private val context: Context
): UserPreferenceDatasource {
    override suspend fun setBoarding(status: Boolean) {
        context.dataStore.edit {
            it[boardingPref] = status
        }
    }

    override suspend fun getBoarding(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[boardingPref] ?: false
        }
    }

    override suspend fun setUsername(username: String) {
        context.dataStore.edit {
            it[usernamePref] = username
        }
    }

    override suspend fun getUsername(): Flow<String> {
        return context.dataStore.data.map {
            it[usernamePref] ?: Constant.USERNAME_PREF
        }
    }

    override suspend fun clearData() {
        context.dataStore.edit {
            it.clear()
        }
    }

    companion object {
        val Context.dataStore by preferencesDataStore(Constant.USER_PREF)
        val usernamePref = stringPreferencesKey(Constant.USERNAME_PREF)
        val boardingPref = booleanPreferencesKey(Constant.BOARDING_PREF)
    }
}