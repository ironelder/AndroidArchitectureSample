package com.min.listApp.ui.viewmodel

import android.util.Log
import androidx.databinding.ObservableArrayList
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.model.KakaoListItemModel
import com.min.listApp.domain.kakaoSearch.KakaoSearchUseCase
import com.min.listApp.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class KakaoImageListViewModel(
    private val kakaoSearchUseCase: KakaoSearchUseCase
) : BaseViewModel() {

    val items: ObservableArrayList<KakaoListItemModel> = ObservableArrayList()

    private var mCategory = KakaoCategory.WEB

    fun searchKakao(keyword: String) {
        addDisposable {
            kakaoSearchUseCase.getSearch(
                category = mCategory.categoryString,
                keyword = keyword,
                size = mCategory.defSize,
                page = mCategory.defPage
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //view?.updateList(category = mCategory, listItemModels = it.listItemModels)
                    items.addAll(it.listItemModels)
                }, {
                    Log.e("MIN", "KakaoSearch Error => ${it.message}")
                })
        }
    }

    fun setCategory(category: String) {
        mCategory = KakaoCategory.fromString(category)
    }


}