package com.arifwidayana.challengechapter4.data.model.request

data class AddStocksRequest(
    val codeStocks: String,
    val nameStocks: String,
    val valueEquity: Int,
    val valueNetProfit: Int,
    val priceBookValue: Double,
    val earningsPerShare: Double,
    val shareValue: Int,
    val sharePrice: Int,
)
