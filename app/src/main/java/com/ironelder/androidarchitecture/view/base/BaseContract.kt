package com.ironelder.androidarchitecture.view.base

interface BaseContract {
    interface View

    interface Presenter<in VIEW : View> {
        fun createView(view: VIEW)
        fun destroyView()
    }
}