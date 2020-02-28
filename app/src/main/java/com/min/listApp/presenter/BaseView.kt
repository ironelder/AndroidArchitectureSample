package com.min.listApp.presenter

interface BaseView<P: BasePresenter> {
    var presenter: P
    fun initLayout()
}