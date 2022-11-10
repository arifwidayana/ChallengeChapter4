package com.arifwidayana.challengechapter4.ui.auth.login

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.data.model.request.LoginRequest
import com.arifwidayana.challengechapter4.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    FragmentLoginBinding::inflate
) {
    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply {
            tvSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnLogin.setOnClickListener {
                loginUser()
            }
        }
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.loginResult.collect {
                if (it is Resource.Success) {
                    findNavController().navigate(R.id.action_loginFragment_to_homepageFragment)
                }
            }
        }
    }

    private fun loginUser() {
        binding.apply {
            viewModelInstance.loginUser(
                LoginRequest(
                    username = etUsername.text.toString(),
                    password = etPassword.text.toString()
                )
            )
        }
    }
}