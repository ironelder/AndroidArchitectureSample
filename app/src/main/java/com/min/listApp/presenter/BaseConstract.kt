package com.min.listApp.presenter

interface BaseConstract {
    interface Presenter {
        fun start()
    }

    interface View<P: Presenter> {
        var presenter: P
        fun initLayout()
    }

}