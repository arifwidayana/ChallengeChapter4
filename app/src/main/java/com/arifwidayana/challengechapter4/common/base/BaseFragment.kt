package com.arifwidayana.challengechapter4.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalArgumentException
import javax.inject.Inject

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel>(
    private val bindingFactory: (LayoutInflater) -> VB
): Fragment(), BaseView {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding as VB
    @Inject
    protected lateinit var viewModelInstance: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingFactory.invoke(inflater)
        when (_binding) {
            null -> throw IllegalArgumentException("Binding cannot be null")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun initView()
    abstract fun observeData()

    override fun showContent(isVisible: Boolean) {
        //do nothing
    }

    override fun showLoading(isVisible: Boolean) {
        //do nothing
    }

    override fun showContentEmpty(isVisible: Boolean) {
        //do nothing
    }

    override fun showError(isErrorEnabled: Boolean, msg: String?) {
        when{
            isErrorEnabled -> {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun showMessage(isErrorEnabled: Boolean, msg: String?) {
        when {
            isErrorEnabled -> {
                msg?.let {
                    Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}