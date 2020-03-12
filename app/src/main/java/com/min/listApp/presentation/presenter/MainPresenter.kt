package com.min.listApp.presentation.presenter

import android.util.Log
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.domain.kakaoSearch.KakaoSearchUseCase
import com.min.listApp.presentation.constract.MainConstract

class MainPresenter(override var view: MainConstract.View) : MainConstract.Presenter {

    private var mCategory = KakaoCategory.WEB

    private val kakaoSearchUseCase by lazy {
        return@lazy KakaoSearchUseCase()
    }

    override fun searchKakao(keyword: String) {
        kakaoSearchUseCase.getSearch(
            category = mCategory.categoryString,
            keyword = keyword,
            size = mCategory.defSize,
            page = mCategory.defPage,
            responseSuccess = { view.updateList(it.listItemModels) },
            responseFailure = { Log.e("MIN", "Kakao Search Error => $it") }
        )
    }

    override fun setCategory(category: String) {
        mCategory = KakaoCategory.fromString(category)
    }

    override fun start() {
        view.initLayout()
    }

}