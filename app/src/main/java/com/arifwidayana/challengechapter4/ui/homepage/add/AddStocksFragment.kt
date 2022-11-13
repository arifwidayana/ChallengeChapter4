package com.arifwidayana.challengechapter4.ui.homepage.add

import androidx.lifecycle.lifecycleScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseDialogFragment
import com.arifwidayana.challengechapter4.data.model.request.AddStocksRequest
import com.arifwidayana.challengechapter4.databinding.FragmentAddStocksBinding
import com.arifwidayana.challengechapter4.utils.calculateEps
import com.arifwidayana.challengechapter4.utils.calculatePbv
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStocksFragment : BaseDialogFragment<FragmentAddStocksBinding, AddStocksViewModel>(
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
                    priceBookValue = calculatePbv(
                        equityStocks = etEquityStocks.text.toString().toInt(),
                        sharesStocks = etShareStocks.text.toString().toInt(),
                        priceStocks = etPriceShareStocks.text.toString().toInt()
                    ),
                    earningsPerShare = calculateEps(
                        sharesStocks = etShareStocks.text.toString().toInt(),
                        netProfitStocks = etNetProfitStocks.text.toString().toInt()
                    ),
                    shareValue = etShareStocks.text.toString().toInt(),
                    sharePrice = etPriceShareStocks.text.toString().toInt()
                )
            )
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