package com.min.listApp.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.min.listApp.databinding.ActivityMainBinding

abstract class BaseActivity<V : BaseConstract.View, P : BaseConstract.Presenter<V>, B: ViewDataBinding>(val resId: Int) :
    AppCompatActivity() {
    abstract val presenter: P
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        presenter.start()
    }
}