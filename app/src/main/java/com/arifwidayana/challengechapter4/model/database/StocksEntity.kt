package com.arifwidayana.challengechapter4.model.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class StocksEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var codeStock: String?,
    var nameStock: String?,
    var valueEquity: Double,
    var valueNetProfit: Double,
    var priceBookValue: Double,
    var earningsPerShare: Double,
    var sharePrice: Int?,
    val shareStock: Int?
) : Parcelable
