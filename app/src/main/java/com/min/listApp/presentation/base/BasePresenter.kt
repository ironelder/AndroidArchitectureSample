package com.min.listApp.presentation.base

import com.min.listApp.presentation.component.MyDisposeable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V: BaseConstract.View>(val view: V): BaseConstract.Presenter, MyDisposeable {

    override val disposeBag by lazy {
        return@lazy CompositeDisposable()
    }

    override fun addDisposable(disposable: Disposable) {
        disposeBag.add(disposable)
    }

    override fun willViewDestory() {
        disposeBag.dispose()
    }

    override fun didViewCreate() {
        view.initLayout()
    }
}