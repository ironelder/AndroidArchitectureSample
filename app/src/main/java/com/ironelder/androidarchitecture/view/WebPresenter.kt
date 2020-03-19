package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BasePresenter

class WebPresenter(private val useCase: NetworkUseCase):BasePresenter<WebContract.View> (), WebContract.Presenter {
    override fun searchData(category: String, query: String) {
    }
}