package com.arifwidayana.challengechapter4.ui.auth.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challengechapter4.R
import com.arifwidayana.challengechapter4.databinding.FragmentRegisterBinding
import com.arifwidayana.challengechapter4.data.StocksDatabase
import com.arifwidayana.challengechapter4.data.model.entity.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var bind: FragmentRegisterBinding? = null
    private val binding get() = bind!!
    private var dataUser: StocksDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
    }
}
