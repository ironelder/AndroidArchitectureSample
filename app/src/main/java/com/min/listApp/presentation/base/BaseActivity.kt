package com.min.listApp.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.min.listApp.presentation.component.Disposable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<V : BaseConstract.View, P : BaseConstract.Presenter<V>, B: ViewDataBinding>(val resId: Int) :
    AppCompatActivity(), Disposable {
    abstract val presenter: P
    protected lateinit var binding: B

    override val compositeDisposable = CompositeDisposable()

    override fun addDisposable(disposable: io.reactivex.disposables.Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        presenter.start()
    }

    override fun onDestroy() {
        presenter.end()
        compositeDisposable.dispose()
        super.onDestroy()
    }
}