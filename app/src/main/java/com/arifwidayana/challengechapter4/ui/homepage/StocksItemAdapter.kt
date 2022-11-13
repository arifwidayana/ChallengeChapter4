package com.arifwidayana.challengechapter4.ui.homepage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifwidayana.challengechapter4.databinding.ItemStocksBinding
import com.arifwidayana.challengechapter4.data.model.entity.StocksEntity
import kotlinx.coroutines.DelicateCoroutinesApi

@SuppressLint("SetTextI18n")
class StocksItemAdapter(private val onClick: (StocksEntity) -> Unit): RecyclerView.Adapter<StocksItemAdapter.StockHolder>() {
    private val listStocks = mutableListOf<StocksEntity?>()
    class StockHolder(
        private val binding: ItemStocksBinding,
        private val onClick: (StocksEntity) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(stocksEntity: StocksEntity) {
            binding.apply {
                with(stocksEntity) {
                    tvCodeStocks.text = codeStock
                    tvNameStocks.text = nameStock
                    tvEquityStocks.text = "Equity: $valueEquity"
                    tvNetProfitStocks.text = "Net Profit: $valueNetProfit"
                    tvEpsStocks.text = "EPS: $priceBookValue"
                    tvPbvStocks.text = "PBV: $earningsPerShare"
                    tvSharesStocks.text = "Total Shares: $shareStock"
                    tvSharePriceStocks.text = "+$sharePrice"
                    root.setOnClickListener {
                        onClick(stocksEntity)
                    }
                }
            }
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked()
    }

    private lateinit var onClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockHolder {
        return StockHolder(ItemStocksBinding.inflate(LayoutInflater.from(parent.context)), onClick)
    }

    @DelicateCoroutinesApi
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: StockHolder, position: Int) {
        listStocks[position]?.let { holder.bind(it) }
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
