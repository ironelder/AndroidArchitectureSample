package com.ironelder.androidarchitecture.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

//abstract class BaseActivity<in VIEW : BaseContract.View, PRESENTER : BaseContract.Presenter<VIEW>>(
abstract class BaseActivity<in VIEW : BaseContract.View, PRESENTER : BaseContract.Presenter<VIEW>, BINDING : ViewDataBinding>(
private val resLayoutId: Int
) : AppCompatActivity(resLayoutId) , BaseContract.View{
    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resLayoutId)
        presenter?.createView(this as VIEW)
        initializedView(savedInstanceState)
        binding.lifecycleOwner = this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroyView()
    }

    abstract val presenter:PRESENTER
    abstract fun initializedView(savedInstanceState: Bundle?)

}