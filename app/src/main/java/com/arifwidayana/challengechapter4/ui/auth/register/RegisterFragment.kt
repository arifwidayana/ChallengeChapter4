package com.arifwidayana.challengechapter4.ui.auth.register

import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.common.Resource
import com.arifwidayana.challengechapter4.common.base.BaseFragment
import com.arifwidayana.challengechapter4.data.model.request.RegisterRequest
import com.arifwidayana.challengechapter4.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>(
    FragmentRegisterBinding::inflate
) {
    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply {
            btnRegister.setOnClickListener {
                registerUser()
            }
            requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
            })
        }
    }

    private fun registerUser() {
        binding.apply {
            viewModelInstance.registerUser(
                RegisterRequest(
                    username = etRegisterUsername.text.toString(),
                    name = etRegisterName.text.toString(),
                    password = etRegisterPassword.text.toString()
                )
            )
        }
    }

    override fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModelInstance.registerResult.collect {
                if (it is Resource.Success) {
                    showError(true, it.message.toString())
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else if (it is Resource.Error) {
                    showMessage(true, it.message.toString())
                }
            }
        }
    }
}
