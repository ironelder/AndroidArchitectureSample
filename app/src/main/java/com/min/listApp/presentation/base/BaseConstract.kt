package com.min.listApp.presentation.base

interface BaseConstract {

    interface Presenter {
        fun didViewCreate()
        fun willViewDestory()
    }

    interface View {
        val presenter: Presenter
        fun initLayout()
    }
}
