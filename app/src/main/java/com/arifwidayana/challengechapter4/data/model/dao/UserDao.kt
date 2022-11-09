package com.arifwidayana.challengechapter4.data.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password")
    fun loginUser(username: String, password: String): Flow<UserEntity?>

    @Query("SELECT * FROM user_table WHERE username = :username")
    fun getUser(username: String): Flow<UserEntity?>
}