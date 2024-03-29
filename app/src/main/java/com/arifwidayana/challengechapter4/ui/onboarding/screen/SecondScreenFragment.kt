package com.arifwidayana.challengechapter4.ui.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.databinding.FragmentSecondScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondScreenFragment : Fragment() {
    private var bind: FragmentSecondScreenBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val secondScreen = activity?.findViewById<ViewPager2>(R.id.vp_on_boarding)
        binding.tvSecondStep.setOnClickListener {
            secondScreen?.currentItem = 2
        }
    }
}