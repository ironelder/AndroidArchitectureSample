package com.ironelder.androidarchitecture.view.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<in VIEW : BaseContract.View, PRESENTER : BaseContract.Presenter<VIEW>, BINDING : ViewDataBinding>(
    private val resId: Int
) : Fragment(resId), BaseContract.View {
    protected lateinit var binding: BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.createView(this as VIEW)
        initializedView(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroyView()
    }

    abstract val presenter:PRESENTER
    abstract fun initializedView(savedInstanceState: Bundle?)

}