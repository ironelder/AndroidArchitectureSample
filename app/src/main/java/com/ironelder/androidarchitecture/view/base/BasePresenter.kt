package com.ironelder.androidarchitecture.view.base

import android.util.Log
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<VIEW : BaseContract.View> : BaseContract.Presenter<VIEW> {
    protected var view: VIEW? = null
        private set
    protected val disposeBag = CompositeDisposable()

    override fun createView(view: VIEW) {
        Log.d("ironelderLog", "BasePresenter createView")
        this.view = view
    }

    override fun destroyView() {
        this.view = null
        disposeBag.dispose()
    }
}