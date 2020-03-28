package com.min.listApp.ui.base

import com.min.listApp.ui.component.MyDisposeable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V: BaseConstract.View>(var view: V?): BaseConstract.Presenter, MyDisposeable {

    override val disposeBag by lazy {
        return@lazy CompositeDisposable()
    }

    override fun addDisposable(disposable: Disposable) {
        disposeBag.add(disposable)
    }

    override fun willViewDestory() {
        disposeBag.dispose()
        view = null
    }

    override fun didViewCreate() {
    }
}