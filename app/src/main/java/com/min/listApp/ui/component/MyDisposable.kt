package com.min.listApp.ui.component

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface MyDisposable {
    val disposeBag: CompositeDisposable
    fun addDisposable(disposable: () -> Disposable) : Boolean = disposable.let { disposeBag.add(it()) }
}