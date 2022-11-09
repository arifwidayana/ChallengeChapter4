package com.arifwidayana.challengechapter4.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.databinding.FragmentThirdScreenBinding
import com.arifwidayana.challengechapter4.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreenFragment : Fragment() {
    private var bind: FragmentThirdScreenBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
            onBoardingFinish()
        }
    }

    private fun onBoardingFinish() {
        val sharedPref = requireActivity().getSharedPreferences(Constant.ON_BOARDING, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.apply{
            putBoolean(Constant.FINISHED, true)
            apply()
        }
    }
}