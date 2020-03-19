package com.ironelder.androidarchitecture.view

import android.util.Log
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.view.base.BasePresenter

class MainPresenter(private val networkUseCase: NetworkUseCase) : BasePresenter<WebContract.View>(), WebContract.Presenter {
    override fun searchData(category: String, query: String) {
        view?.apply {
            showLoading()
        }
//        RemoteRepositoryImpl.searchForKakao(category, query, ::onSuccess, ::onFail)
        networkUseCase.getSearchDataUseCase(category, query, ::onSuccess, ::onFail)
    }

    private fun onFail(message: String) {
        view?.apply {
            hideLoading()
            showErrorMessage(message)
            Log.d("ironelderLog", "message $message ")
        }
    }

    private fun onSuccess(result: DataModel) {
        view?.apply {
            onDataChanged(result.listItems)
            hideLoading()
        }
    }

}