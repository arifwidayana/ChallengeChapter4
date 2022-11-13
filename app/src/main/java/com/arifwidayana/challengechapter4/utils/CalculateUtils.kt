package com.arifwidayana.challengechapter4.utils

fun calculatePbv(equityStocks: Int, sharesStocks: Int, priceStocks: Int): Double =
    priceStocks/(equityStocks/sharesStocks).toDouble()

fun calculateEps(sharesStocks: Int, netProfitStocks: Int): Double =
    netProfitStocks.toDouble()/sharesStocks