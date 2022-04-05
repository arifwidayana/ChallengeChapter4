package com.arifwidayana.challengechapter4.model

import androidx.room.PrimaryKey

data class Fudamentals(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var codeStock: String?,
    var nameStock: String?,
    var valueEquity: Double,
    var valueNetProfit: Double,
    var priceBookValue: Double,
    var earningsPerShare: Double,
    var sharePrice: Int?,
    val shareStock: Int?
)
