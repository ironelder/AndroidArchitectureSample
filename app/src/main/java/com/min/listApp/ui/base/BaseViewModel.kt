package com.min.listApp.ui.base

import androidx.lifecycle.ViewModel
import com.min.listApp.ui.component.MyDisposable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(), MyDisposable {

    override val disposeBag by lazy {
        return@lazy CompositeDisposable()
    }

    override fun onCleared() {
        super.onCleared()
        disposeBag.dispose()
    }
}