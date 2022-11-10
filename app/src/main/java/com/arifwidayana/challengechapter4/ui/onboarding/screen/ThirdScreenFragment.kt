package com.arifwidayana.challengechapter4.ui.onboarding.screen

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.databinding.FragmentThirdScreenBinding
import com.arifwidayana.challengechapter4.ui.onboarding.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreenFragment : BaseFragment<FragmentThirdScreenBinding, OnBoardingViewModel>(
    FragmentThirdScreenBinding::inflate
) {
    override fun initView() {
        viewModelInstance.boardingPref()
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.boardingPrefResult.collect {
                if (it is Resource.Success) {
                    findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)
                }
            }
        }
    }
}