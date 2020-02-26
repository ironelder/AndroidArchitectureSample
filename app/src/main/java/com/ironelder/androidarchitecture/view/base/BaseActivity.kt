package com.ironelder.androidarchitecture.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<in VIEW : BaseContract.View, PRESENTER : BaseContract.Presenter<VIEW>>(
    resLayoutId: Int
) : AppCompatActivity(resLayoutId) , BaseContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.createView(this as VIEW)
        initializedView(savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.destroyView()
    }

    abstract val presenter:PRESENTER
    abstract fun initializedView(savedInstanceState: Bundle?)

}