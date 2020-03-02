package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.data.model.BlogListItem
import com.ironelder.androidarchitecture.view.base.BaseContract

interface MainContract {
    interface View : BaseContract.View {
        fun onDataChanged(result: List<BlogListItem>?)
        fun showErrorMessage(message: String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun searchData(category: String, query: String)
    }
}