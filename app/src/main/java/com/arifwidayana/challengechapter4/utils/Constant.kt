package com.arifwidayana.challengechapter4.utils

object Constant {
    // Datastore
    const val USER_PREF = "USER_PREF"
    const val USERNAME_PREF = "USERNAME_PREF"
    const val BOARDING_PREF = "BOARDING_PREF"

    // DB
    const val STOCK_DB = "Stocks.db"

    // Query Request
    const val GET_STOCKS = "SELECT * FROM stock_table WHERE user_stock = :username"
    const val GET_STOCKS_BY_ID = "SELECT * FROM stock_table WHERE id = :idStocks"
    const val DELETE_STOCKS = "DELETE FROM stock_table WHERE id = :idStocks"
    const val LOGIN_USER = "SELECT * FROM user_table WHERE username = :username AND password = :password"
    const val GET_USER = "SELECT * FROM user_table WHERE username = :username"
}