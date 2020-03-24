package com.ironelder.androidarchitecture.view.blog

import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.view.base.BaseContract

interface BlogContract {
    interface View : BaseContract.View {
        fun onDataChanged(result: List<ListItem>?)
        fun showErrorMessage(message: String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun searchData(category: String, query: String)
    }
}