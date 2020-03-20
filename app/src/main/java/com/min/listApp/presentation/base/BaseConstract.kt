package com.min.listApp.presentation.base

import com.min.listApp.presentation.component.Disposable

interface BaseConstract {

    interface Presenter<V : View> {
        var view: V
        fun start()
        fun end()
    }

    interface View: Disposable {
        fun initLayout()
    }


}
