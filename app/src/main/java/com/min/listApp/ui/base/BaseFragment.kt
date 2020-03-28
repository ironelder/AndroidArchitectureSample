package com.min.listApp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B: ViewDataBinding>(val resId: Int) : Fragment(), BaseConstract.View {

    protected lateinit var binding: B

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil.inflate(inflater, resId, container, false)
         binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        presenter.didViewCreate()
    }

    override fun onDestroyView() {
        presenter.willViewDestory()
        super.onDestroyView()
    }

    abstract fun initLayout()
}