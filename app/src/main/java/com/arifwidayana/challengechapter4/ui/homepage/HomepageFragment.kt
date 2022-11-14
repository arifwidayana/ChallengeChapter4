package com.arifwidayana.challengechapter4.ui.homepage

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.databinding.FragmentHomepageBinding
import com.arifwidayana.challengechapter4.ui.homepage.add.AddStocksFragment
import com.arifwidayana.challengechapter4.ui.homepage.edit.EditStocksFragment
import dagger.hilt.android.AndroidEntryPoint

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
                        adapter = StocksItemAdapter { data ->
                            EditStocksFragment(data.id).show(childFragmentManager, null)
                        }
                        binding.rvStocks.adapter = adapter
                        it.data?.let { it1 -> adapter.setData(it1) }
                        Handler(Looper.getMainLooper()).postDelayed({
                            viewModelInstance.getStocks()
                        }, 3000)
                    }
                }
            }
        }
    }
}