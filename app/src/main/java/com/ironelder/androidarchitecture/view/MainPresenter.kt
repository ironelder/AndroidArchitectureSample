package com.ironelder.androidarchitecture.view

import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BasePresenter

class MainPresenter(private val networkUseCase: NetworkUseCase) : BasePresenter<WebContract.View>(), WebContract.Presenter {
    override fun searchData(category: String, query: String) {
        view?.apply {
            showLoading()
        }
//        RemoteRepositoryImpl.searchForKakao(category, query, ::onSuccess, ::onFail)
//        disposeBag.add(
//            networkUseCase.getSearchDataUseCase(category, query, ::onSuccess, ::onFail)
//                .subscribeOn(Schedulers.io()).subscribe({
//                    onSuccess(it)
//                }, {
//                    Log.d("ironelderLog", "error = ${it.message}")
//                })
//        )
    }

    private fun onFail(message: String) {
//        view?.apply {
//            hideLoading()
//            showErrorMessage(message)
//            Log.d("ironelderLog", "message $message ")
//        }
    }

    private fun onSuccess(result: DataModel) {
//        view?.apply {
//            onDataChanged(result.listItems)
//            hideLoading()
//        }
    }

    override fun destroyView() {
        super.destroyView()
//        disposeBag.dispose()
    }

}