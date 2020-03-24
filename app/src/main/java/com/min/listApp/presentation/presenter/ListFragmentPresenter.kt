package com.min.listApp.presentation.presenter

import android.util.Log
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.repository.KakaoSearchRepositoryImpl
import com.min.listApp.domain.kakaoSearch.KakaoSearchUseCase
import com.min.listApp.presentation.constract.ListFragmentConstract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListFragmentPresenter(view: ListFragmentConstract.View) : ListFragmentConstract.Presenter(view) {

    private var mCategory = KakaoCategory.WEB

    private val kakaoSearchUseCase by lazy {
        return@lazy KakaoSearchUseCase(KakaoSearchRepositoryImpl)
    }

    override fun searchKakao(keyword: String) {
        kakaoSearchUseCase.getSearch(
            category = mCategory.categoryString,
            keyword = keyword,
            size = mCategory.defSize,
            page = mCategory.defPage
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.updateList(category = mCategory, listItemModels = it.listItemModels)
            }, {
                Log.e("MIN", "KakaoSearch Error => ${it.message}")
            }).let { addDisposable(disposable = it) }
    }

    override fun setCategory(category: String) {
        mCategory = KakaoCategory.fromString(category)
    }


}