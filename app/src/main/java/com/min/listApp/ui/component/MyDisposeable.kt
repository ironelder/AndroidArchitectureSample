package com.min.listApp.ui.component

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface MyDisposeable {
    val disposeBag: CompositeDisposable
    fun addDisposable(disposable: Disposable)


}