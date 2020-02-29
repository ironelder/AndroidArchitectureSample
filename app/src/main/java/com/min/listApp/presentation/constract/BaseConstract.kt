package com.min.listApp.presentation.constract

interface BaseConstract {

    interface Presenter<V: View> {
        var view: V
        fun start()
    }

    interface View {

        fun initLayout()
    }


}
