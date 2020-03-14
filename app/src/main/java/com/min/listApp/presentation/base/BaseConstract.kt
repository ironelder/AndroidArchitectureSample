package com.min.listApp.presentation.base

interface BaseConstract {

    interface Presenter<V : View> {
        var view: V
        fun start()
        fun end()
    }

    interface View {
        fun initLayout()
    }


}
