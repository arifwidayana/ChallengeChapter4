package com.arifwidayana.challengechapter4

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.view.onboarding.ThirdScreen

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardingFinish()) {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinish(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences(ThirdScreen.ON_BOARDING, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(ThirdScreen.FINISHED, false)
    }
}