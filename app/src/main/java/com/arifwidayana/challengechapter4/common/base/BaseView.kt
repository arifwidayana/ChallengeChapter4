package com.arifwidayana.challengechapter4.common.base

interface BaseView {
    fun showContent(isVisible: Boolean)
    fun showContentEmpty(isVisible: Boolean)
    fun showLoading(isVisible: Boolean)
    fun showError(isErrorEnabled: Boolean, msg: String? = null)
    fun showMessage(isErrorEnabled: Boolean, msg: String? = null)
}