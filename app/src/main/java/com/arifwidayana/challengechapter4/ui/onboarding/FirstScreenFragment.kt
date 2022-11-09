package com.arifwidayana.challengechapter4.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.databinding.FragmentFirstScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreenFragment : Fragment() {
    private var bind: FragmentFirstScreenBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstScreen = activity?.findViewById<ViewPager2>(R.id.vp_on_boarding)
        binding.tvFirstStep.setOnClickListener {
            firstScreen?.currentItem = 1
        }
    }
}