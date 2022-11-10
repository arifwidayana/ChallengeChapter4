package com.arifwidayana.challengechapter4.ui.auth.register

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
        onView()
        onClick()
    }

    private fun onView() {
        binding.apply {
            // do nothing
        }
    }

    private fun onClick() {
        binding.apply {
            btnRegister.setOnClickListener {
                registerUser()
            }
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
                when(it) {
                    is Resource.Loading -> {}
                    is Resource.Empty -> {}
                    is Resource.Success -> {
                        showError(true, it.message.toString())
                        findNavController().popBackStack()
                    }
                    is Resource.Error -> {
                        showMessage(true, it.message.toString())
                    }
                }
            }
        }
    }
    //        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        dataUser = StocksDatabase.getInstance(requireContext())
//
//        binding.apply {
//            etRegisterPassword.addTextChangedListener(object : TextWatcher{
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    when {
//                        etRegisterPassword.text.toString().length <= 8 -> {
//                            etRegisterPassword.error = "At least 8 words password"
//                            etConfirmPassword.error = null
//                        }
//                        etConfirmPassword.text.toString().length <= 8 -> {
//                            etConfirmPassword.error = "At least 8 words confirm password"
//                            etRegisterPassword.error = null
//                        }
//                        else -> {
//                            etRegisterPassword.error = null
//                            etConfirmPassword.error = null
//                        }
//                    }
//                }
//
//                override fun afterTextChanged(p0: Editable?) {}
//
//            })
//
//            etConfirmPassword.addTextChangedListener(object : TextWatcher{
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                    when {
//                        etRegisterPassword.text.toString().length <= 8 -> {
//                            etRegisterPassword.error = "At least 8 words password"
//                            etConfirmPassword.error = null
//                        }
//                        etConfirmPassword.text.toString().length <= 8 -> {
//                            etConfirmPassword.error = "At least 8 words confirm password"
//                            etRegisterPassword.error = null
//                        }
//                        else -> {
//                            etRegisterPassword.error = null
//                            etConfirmPassword.error = null
//                        }
//                    }
//                }
//
//                override fun afterTextChanged(p0: Editable?) {}
//            })
//        }
//
//        binding.apply {
//            btnRegister.setOnClickListener {
//                val objDataUser = UserEntity(null, etRegisterName.text.toString(), etRegisterUsername.text.toString(), etConfirmPassword.text.toString())
//
//                when {
//                    etRegisterName.text.isNullOrEmpty() -> {
//                        tfName.error = "Fill column name"
//                    }
//                    etRegisterUsername.text.isNullOrEmpty() -> {
//                        tfUsername.error = "Fill column username"
//                    }
//                    etRegisterPassword.text.isNullOrEmpty() -> {
//                        tfPassword.error = "Fill column Password"
//                    }
//                    etConfirmPassword.text.isNullOrEmpty() -> {
//                        tfConfPassword.error = "Fill column Confirm Password"
//                    }
//                    etConfirmPassword.text.toString() != etRegisterPassword.text.toString() -> {
//                        Toast.makeText(requireContext(), "Password not Match", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                    else -> {
//                        GlobalScope.async {
//                            dataUser?.userDao()?.insertUser(objDataUser)
//                        }
//                        CoroutineScope(Dispatchers.Main).launch {
//                            Toast.makeText(
//                                requireContext(),
//                                "Register Success",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
//                        }
//                    }
//                }
//            }
//        }
//    }
}
