package com.min.listApp.presentation.view

import android.util.Log
import com.min.listApp.R
import com.min.listApp.data.model.ImageListItemModel
import com.min.listApp.presentation.base.BaseActivity
import com.min.listApp.presentation.constract.MainConstract
import com.min.listApp.presentation.presenter.MainPresenter
import com.min.listApp.presentation.view.component.MainListAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity :
    BaseActivity<MainConstract.View, MainConstract.Presenter>(R.layout.activity_main),
    MainConstract.View {

    override var presenter: MainConstract.Presenter = MainPresenter(this)

    override fun initLayout() {
        val test1 = Observable.just("1", "2", "3").delay(2, TimeUnit.SECONDS)
        val test2 = Observable.just("apple", "banana", "car")
        val test3 = Observable.interval(2, TimeUnit.SECONDS)

        Observable.zip(test3, test2, BiFunction { t1: Long, t2: String -> t1.toString() + t2 })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("zip observable ${System.currentTimeMillis()}", it)
            }, {

            }, {
                Log.e("zip observable ", "complete")
            }).dispose()
    }

    override fun updateList(listItemModels: List<ImageListItemModel>) {
        list_main.adapter = MainListAdapter(listItemModels)
    }
}

