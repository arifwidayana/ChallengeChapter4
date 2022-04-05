package com.arifwidayana.challengechapter4.model.dao

import androidx.room.Dao
import androidx.room.Insert
import com.arifwidayana.challengechapter4.model.database.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertRegisterUser(user: UserEntity): Long
}