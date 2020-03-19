package com.ironelder.androidarchitecture.view.base

import android.util.Log

abstract class BasePresenter<VIEW : BaseContract.View> : BaseContract.Presenter<VIEW> {
    protected var view: VIEW? = null
        private set

    override fun createView(view: VIEW) {
        Log.d("ironelderLog", "BasePresenter createView")
        this.view = view
    }

    override fun destroyView() {
        this.view = null
    }
}