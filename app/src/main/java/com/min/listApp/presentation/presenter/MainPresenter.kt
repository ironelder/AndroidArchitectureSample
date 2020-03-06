package com.min.listApp.presentation.presenter

import android.util.Log
import com.min.listApp.domain.kakaoSearch.KakaoSearchUseCase
import com.min.listApp.presentation.constract.MainConstract

class MainPresenter(override var view: MainConstract.View) :
    MainConstract.Presenter {

    private val kakaoSearchUseCase by lazy {
        return@lazy KakaoSearchUseCase()
    }

    override fun searchKakao(category: String, keyword: String) {
        kakaoSearchUseCase.getSearch(
            category = category,
            keyword = keyword,
            responseSuccess = { view.updateList(it.listItemModels) },
            responseFailure = { Log.e("MIN", "Kakao Search Error => $it") }
        )
    }

    override fun start() {
        view.initLayout()
        searchKakao(
            category = "image",
            keyword = "코로나"
        )
    }

}