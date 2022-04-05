package com.arifwidayana.challengechapter4.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arifwidayana.challengechapter4.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var bind: FragmentLoginBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

}