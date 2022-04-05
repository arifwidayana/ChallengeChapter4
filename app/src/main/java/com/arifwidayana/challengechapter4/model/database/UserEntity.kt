package com.arifwidayana.challengechapter4.model.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val username: String,
    val password: String
) : Parcelable
