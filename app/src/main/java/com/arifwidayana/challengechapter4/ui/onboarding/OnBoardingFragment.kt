package com.arifwidayana.challengechapter4.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arifwidayana.challengechapter4.databinding.FragmentOnBoardingBinding
import com.arifwidayana.challengechapter4.ui.onboarding.screen.FirstScreenFragment
import com.arifwidayana.challengechapter4.ui.onboarding.screen.SecondScreenFragment
import com.arifwidayana.challengechapter4.ui.onboarding.screen.ThirdScreenFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private var bind: FragmentOnBoardingBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = OnBoardingAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.vpOnBoarding.adapter = adapter
    }
}