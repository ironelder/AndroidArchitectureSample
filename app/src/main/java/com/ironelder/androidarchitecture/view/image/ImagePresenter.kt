package com.ironelder.androidarchitecture.view.image

import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImagePresenter(private val useCase: NetworkUseCase) : BasePresenter<ImageContract.View>(),
    ImageContract.Presenter {
    override fun searchData(category: String, query: String) {
        view?.apply {
            showLoading()
        }
        disposeBag.add(useCase.getSearchDataUseCase(category, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.apply {
                        onDataChanged(it.listItems)
                        hideLoading()
                    }
                }, {
                    view?.apply {
                        hideLoading()
                        showErrorMessage(it.message ?: "Error")
                    }
                }
            ))
    }
}