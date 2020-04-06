package com.ironelder.androidarchitecture.view.base

import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel {
    protected val disposeBag = CompositeDisposable()

    fun destroyView() {
        disposeBag.dispose()
    }
}