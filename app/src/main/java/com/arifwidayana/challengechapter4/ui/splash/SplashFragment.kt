package com.arifwidayana.challengechapter4.ui.splash

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.databinding.FragmentSplashBinding
import com.arifwidayana.challengechapter4.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    FragmentSplashBinding::inflate
) {
    override fun initView() {
        viewModelInstance.boardingPref()
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.apply {
                boardingPrefResult.collect {
                    if (it is Resource.Success) {
                        when(it.data) {
                            !true -> {
                                moveNavFragment(R.id.action_splashFragment_to_onBoardingFragment)
                            }
                            else -> {
                                usernamePref()
                            }
                        }
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModelInstance.usernamePrefResult.collect {
                if (it is Resource.Success) {
                    if (it.data == Constant.USERNAME_PREF) {
                        moveNavFragment(R.id.action_splashFragment_to_loginFragment)
                    } else {
                        moveNavFragment(R.id.action_splashFragment_to_homepageFragment)
                    }
                }
            }
        }
    }

    private fun moveNavFragment(navUp: Int) {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(navUp)
        }, 3000)
    }
}