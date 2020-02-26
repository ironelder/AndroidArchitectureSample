package com.ironelder.androidarchitecture.view.base

abstract class BasePresenter<VIEW : BaseContract.View> : BaseContract.Presenter<VIEW> {
    protected var view: VIEW? = null
        private set

    override fun createView(view: VIEW) {
        this.view = view
    }

    override fun destroyView() {
        this.view = null
    }
}