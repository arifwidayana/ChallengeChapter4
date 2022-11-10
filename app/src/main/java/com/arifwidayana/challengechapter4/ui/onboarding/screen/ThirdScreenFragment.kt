package com.arifwidayana.challengechapter4.ui.onboarding.screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.databinding.FragmentThirdScreenBinding
import com.arifwidayana.challengechapter4.ui.onboarding.OnBoardingViewModel
import com.arifwidayana.challengechapter4.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreenFragment : BaseFragment<FragmentThirdScreenBinding, OnBoardingViewModel>(
    FragmentThirdScreenBinding::inflate
) {
    override fun initView() {
        viewModelInstance.apply {  }
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.apply {  }
        }
    }

}