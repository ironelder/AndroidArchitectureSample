package com.ironelder.androidarchitecture.view.web

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.domain.NetworkUseCase
import com.ironelder.androidarchitecture.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WebViewModel(private val useCase: NetworkUseCase) : BaseViewModel() {
    val items: ObservableArrayList<ListItem> = ObservableArrayList()
    val errorMessage: ObservableField<String> = ObservableField()
    val loading:ObservableField<Boolean> = ObservableField()
    fun searchData(category: String, query: String) {
        loading.set(true)
        disposeBag.add(useCase.getSearchDataUseCase(category, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    items.addAll(it.listItems)
                    loading.set(false)
                }, {
                    errorMessage.set(it.message)
                    loading.set(false)
                }
            ))
    }

}