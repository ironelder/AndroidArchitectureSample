package com.min.listApp.presentation.presenter

import com.min.listApp.presentation.constract.MainConstract

class MainPresenter(override var view: MainConstract.View) : MainConstract.Presenter {

    override fun start() {
        view.initLayout()
    }

    override fun end() {

    }

}