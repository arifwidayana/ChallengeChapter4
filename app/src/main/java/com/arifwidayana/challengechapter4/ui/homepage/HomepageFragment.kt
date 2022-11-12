package com.arifwidayana.challengechapter4.ui.homepage

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.databinding.FragmentHomepageBinding
import com.arifwidayana.challengechapter4.ui.homepage.add.AddStocksFragment
import com.arifwidayana.challengechapter4.ui.homepage.edit.EditStocksFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(DelicateCoroutinesApi::class)
@AndroidEntryPoint
class HomepageFragment : BaseFragment<FragmentHomepageBinding, HomepageViewModel>(
    FragmentHomepageBinding::inflate
) {
    private lateinit var adapter: StocksItemAdapter

    override fun initView() {
        onView()
        onClick()
    }

    private fun onView() {
        viewModelInstance.apply {
            getUser()
            getStocks()
        }
    }

    private fun onClick() {
        binding.apply {
            with(viewModelInstance) {
                ivLogout.setOnClickListener {
                    logoutUser()
                    findNavController().navigate(R.id.action_homepageFragment_to_loginFragment)
                }
                ivRefresh.setOnClickListener {
                    getStocks()
                    showError(true, "clicked")
                }
                fabAddStocks.setOnClickListener {
                    AddStocksFragment().show(childFragmentManager, null)
                }
            }
        }
    }

    override fun observeData() {
        lifecycleScope.apply {
            launchWhenStarted {
                viewModelInstance.getUserResult.collect {
                    binding.tvName.text = it.data?.name
                }
            }
            launchWhenStarted {
                viewModelInstance.getStocksResult.collect {
                    if (it is Resource.Success) {
                        val stocksAdapter = StocksItemAdapter()
                        binding.rvStocks.adapter = stocksAdapter
                        it.data?.let { it1 -> stocksAdapter.setData(it1) }
                        adapter.setOnClickCallback(object : StocksItemAdapter.OnItemClickCallback {
                            override fun onItemClicked(listStock: Int) {
                                EditStocksFragment(listStock).show(childFragmentManager, null)
                            }
                        })
                    }
                }
            }
        }
    }
}