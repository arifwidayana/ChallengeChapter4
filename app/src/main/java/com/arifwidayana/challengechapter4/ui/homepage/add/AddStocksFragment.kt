package com.arifwidayana.challengechapter4.ui.homepage.add

import androidx.lifecycle.lifecycleScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseDialogFragment
import com.arifwidayana.challengechapter4.data.model.request.AddStocksRequest
import com.arifwidayana.challengechapter4.databinding.FragmentAddStocksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStocksFragment() : BaseDialogFragment<FragmentAddStocksBinding, AddStocksViewModel>(
    FragmentAddStocksBinding::inflate
) {
    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply {
            btnAddStocks.setOnClickListener {
                addStocks()
            }
            btnCancelSave.setOnClickListener {
                showMessage(true, "You have canceled to add stocks")
                dismiss()
            }
        }
    }

    private fun addStocks() {
        binding.apply {
            viewModelInstance.insertStocks(
                AddStocksRequest(
                    codeStocks = etCodeStocks.text.toString(),
                    nameStocks = etNameStocks.text.toString(),
                    valueEquity = etEquityStocks.text.toString().toInt(),
                    valueNetProfit = etNetProfitStocks.text.toString().toInt(),
                    priceBookValue = calculatePbv(),
                    earningsPerShare = calculateEps(),
                    shareValue = etShareStocks.text.toString().toInt(),
                    sharePrice = etPriceShareStocks.text.toString().toInt()
                )
            )
        }
    }

    private fun calculatePbv(): Double {
        binding.apply {
            val equityStocks = etEquityStocks.text.toString().toInt()
            val sharesStocks = etShareStocks.text.toString().toInt()
            val priceStocks = etPriceShareStocks.text.toString().toInt()
            val bvStocks = equityStocks/sharesStocks
            return priceStocks/bvStocks.toDouble()
        }
    }

    private fun calculateEps(): Double {
        binding.apply {
            val sharesStocks = etShareStocks.text.toString().toInt()
            val netProfitStocks = etNetProfitStocks.text.toString().toInt()
            return netProfitStocks.toDouble()/sharesStocks
        }
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.insertStocksResult.collect {
                if (it is Resource.Success) {
                    showMessage(true, "Add stocks success")
                    dismiss()
                }
            }
        }
    }
}