package com.arifwidayana.challengechapter4.ui.homepage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifwidayana.challengechapter4.ui.MainActivity
import com.arifwidayana.challengechapter4.databinding.ItemStocksBinding
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import com.arifwidayana.challengechapter4.ui.homepage.edit.EditStocksFragment
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class StocksItemAdapter: RecyclerView.Adapter<StocksItemAdapter.StockHolder>() {
    private val listStocks = mutableListOf<StocksEntity?>()
    class StockHolder(val binding: ItemStocksBinding): RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback{
        fun onItemClicked(listStock: Int)
    }

    private lateinit var onClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockHolder {
        return StockHolder(ItemStocksBinding.inflate(LayoutInflater.from(parent.context)))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StockHolder, position: Int) {
        with(holder.binding) {
            tvCodeStocks.text = listStocks[position]?.codeStock
            tvNameStocks.text = listStocks[position]?.nameStock
            tvEquityStocks.text = "Equity: ${listStocks[position]?.valueEquity.toString()}"
            tvNetProfitStocks.text = "Net Profit: ${listStocks[position]?.valueNetProfit.toString()}"
            tvEpsStocks.text = "EPS: ${listStocks[position]?.earningsPerShare.toString()}"
            tvPbvStocks.text = "PBV: ${listStocks[position]?.priceBookValue.toString()}"
            tvSharesStocks.text = "Total Shares: ${listStocks[position]?.shareStock.toString()}"
            tvSharePriceStocks.text = "+${listStocks[position]?.sharePrice.toString()}"

            root.setOnClickListener {
                val activity = it.context as MainActivity
                val sendFrag = EditStocksFragment(listStocks[position]?.id)
                sendFrag.show(activity.supportFragmentManager, null)
            }
        }
    }

    override fun getItemCount(): Int {
        return listStocks.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData (listStock: List<StocksEntity?>){
        listStocks.clear()
        listStocks.addAll(listStock)
        notifyDataSetChanged()
    }
}
