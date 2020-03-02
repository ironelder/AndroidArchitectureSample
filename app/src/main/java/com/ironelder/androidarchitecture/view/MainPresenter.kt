package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.data.repository.RemoteRepositoryImpl
import com.ironelder.androidarchitecture.view.base.BasePresenter

class MainPresenter : BasePresenter<MainContract.View>(), MainContract.Presenter {
    override fun searchData(category: String, query: String) {
        view?.apply {
            showLoading()
        }
        RemoteRepositoryImpl.searchForKakao(category, query, ::onSuccess, ::onFail)
    }

    private fun onFail(message: String) {
        view?.apply {
            hideLoading()
            showErrorMessage(message)
        }
    }

    private fun onSuccess(result: DataModel) {
        view?.apply {
            onDataChanged(result.listItems)
            hideLoading()
        }
    }

}