package com.min.listApp.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.min.listApp.presentation.component.MyDisposeable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<B: ViewDataBinding>(val resId: Int) :
    AppCompatActivity(),  BaseConstract.View {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        presenter.didViewCreate()
    }

    override fun onDestroy() {
        presenter.willViewDestory()
        super.onDestroy()
    }
}