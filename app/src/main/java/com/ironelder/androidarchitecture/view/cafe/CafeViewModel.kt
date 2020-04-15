package com.ironelder.androidarchitecture.view.cafe

import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CafeViewModel(private val useCase: NetworkUseCase) : BaseViewModel() {
    fun searchData(category: String, query: String) {
        disposeBag.add(useCase.getSearchDataUseCase(category, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                }, {
                }
            ))
    }
}