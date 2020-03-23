package com.ironelder.androidarchitecture.view

import android.util.Log
import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WebPresenter(private val useCase: NetworkUseCase) : BasePresenter<WebContract.View>(),
    WebContract.Presenter {
    override fun searchData(category: String, query: String) {
        Log.d("ironelderLog","searchData = $view" )
        view?.apply {
            showLoading()
        }
        useCase.getSearchDataUseCase(category, query, ::onSuccess, ::onFail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {
                Log.d("ironelderLog","success = $it" )
            },{
                Log.d("ironelderLog","error = ${it.message}" )
            }
        )
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