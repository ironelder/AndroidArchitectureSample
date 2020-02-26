package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.data.model.Document
import com.ironelder.androidarchitecture.view.base.BaseContract

interface MainContract {
    interface View : BaseContract.View {
        fun onDataChanged(result:List<Document>?)
        fun showErrorMessage(message:String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun searchData(category:String, query:String)
    }
}