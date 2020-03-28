package com.min.listApp.ui.base

interface BaseConstract {

    interface Presenter {
        fun didViewCreate()
        fun willViewDestory()
    }

    interface View {
        val presenter: Presenter
    }
}
