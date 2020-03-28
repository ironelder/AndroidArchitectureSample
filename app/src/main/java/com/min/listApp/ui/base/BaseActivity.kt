package com.min.listApp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding>(val resId: Int) :
    AppCompatActivity(),  BaseConstract.View {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        initLayout()
        presenter.didViewCreate()
    }

    override fun onDestroy() {
        presenter.willViewDestory()
        super.onDestroy()
    }

    abstract fun initLayout()
}