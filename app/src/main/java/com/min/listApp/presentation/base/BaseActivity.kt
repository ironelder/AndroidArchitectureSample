package com.min.listApp.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<V : BaseConstract.View, P : BaseConstract.Presenter<V>>(val resId: Int) :
    AppCompatActivity() {
    abstract val presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resId)
        presenter.start()
    }
}