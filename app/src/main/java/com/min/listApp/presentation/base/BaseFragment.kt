package com.min.listApp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<V : BaseConstract.View, P : BaseConstract.Presenter<V>, B: ViewDataBinding>(val resId: Int) : Fragment() {
    abstract val presenter: P
    lateinit var binding: B

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false)
        presenter.start()
        return binding.root
    }


    override fun onDestroyView() {
        presenter.end()
        super.onDestroyView()
    }
}