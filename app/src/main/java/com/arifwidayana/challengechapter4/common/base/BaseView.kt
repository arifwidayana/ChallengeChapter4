package com.arifwidayana.challengechapter4.common.base

interface BaseView {
    fun showError(isErrorEnabled: Boolean, msg: String? = null)
    fun showMessage(isErrorEnabled: Boolean, msg: String? = null)
}