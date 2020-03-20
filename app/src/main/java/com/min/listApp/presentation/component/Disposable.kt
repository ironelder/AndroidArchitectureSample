package com.min.listApp.presentation.component

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface Disposable {
    val compositeDisposable: CompositeDisposable
    fun addDisposable(disposable: Disposable)
}