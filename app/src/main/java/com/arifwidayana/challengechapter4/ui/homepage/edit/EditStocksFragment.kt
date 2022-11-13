package com.arifwidayana.challengechapter4.ui.homepage.edit

import androidx.lifecycle.lifecycleScope
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseDialogFragment
import com.arifwidayana.challengechapter4.databinding.FragmentEditStocksBinding
import com.arifwidayana.challengechapter4.data.model.request.EditStocksRequest
import com.arifwidayana.challengechapter4.utils.calculateEps
import com.arifwidayana.challengechapter4.utils.calculatePbv
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditStocksFragment(idStocks: Int?) :
    BaseDialogFragment<FragmentEditStocksBinding, EditStocksViewModel>(
        FragmentEditStocksBinding::inflate
    ) {
    private val idStocksData = idStocks

    override fun initView() {
        onView()
        onClick()
    }

    private fun onView() {
        viewModelInstance.getStocksById(idStocksData ?: 0)
    }

    private fun onClick() {
        binding.apply {
            btnEditStocks.setOnClickListener {
                editStocks()
            }
            btnDeleteStocks.setOnClickListener {
                deleteStocks()
            }
        }
    }

    private fun editStocks() {
        binding.apply {
            viewModelInstance.updateStocks(
                EditStocksRequest(
                    id = idStocksData ?: 0,
                    codeStocks = etEditCodeStocks.text.toString(),
                    nameStocks = etEditNameStocks.text.toString(),
                    valueEquity = etEditEquityStocks.text.toString().toInt(),
                    valueNetProfit = etEditNetProfitStocks.text.toString().toInt(),
                    priceBookValue = calculatePbv(
                        equityStocks = etEditEquityStocks.text.toString().toInt(),
                        sharesStocks = etEditShareStocks.text.toString().toInt(),
                        priceStocks = etEditPriceShareStocks.text.toString().toInt()
                    ),
                    earningsPerShare = calculateEps(
                        sharesStocks = etEditShareStocks.text.toString().toInt(),
                        netProfitStocks = etEditNetProfitStocks.text.toString().toInt()
                    ),
                    shareValue = etEditShareStocks.text.toString().toInt(),
                    sharePrice = etEditPriceShareStocks.text.toString().toInt()
                )
            )
        }
    }

    private fun deleteStocks() {
        viewModelInstance.deleteStocks(idStocksData ?: 0)
    }

    override fun observeData() {
        lifecycleScope.apply {
            with(viewModelInstance) {
                launchWhenStarted {
                    getStocksByIdResult.collect {
                        binding.apply {
                            it.data?.let { result ->
                                etEditCodeStocks.setText(result.codeStock)
                                etEditNameStocks.setText(result.nameStock)
                                etEditEquityStocks.setText(result.valueEquity.toString())
                                etEditNetProfitStocks.setText(result.valueNetProfit.toString())
                                etPbvStocks.setText(result.priceBookValue.toString())
                                etEpsStocks.setText(result.earningsPerShare.toString())
                                etEditPriceShareStocks.setText(result.sharePrice.toString())
                                etEditShareStocks.setText(result.shareStock.toString())
                            }
                        }
                    }
                }
                launchWhenStarted {
                    updateStocksResult.collect {
                        if (it is Resource.Success) {
                            showError(true, it.message)
                            dismiss()
                        }
                    }
                }
                launchWhenStarted {
                    deleteStocksResult.collect {
                        if (it is Resource.Success) {
                            showError(true, it.message)
                            dismiss()
                        }
                    }
                }
            }
        }
    }
}