package com.min.listApp.presentation.component

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface MyDisposeable {
    val disposeBag: CompositeDisposable
    fun addDisposable(disposable: Disposable)


}