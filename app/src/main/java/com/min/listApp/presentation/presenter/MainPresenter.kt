package com.min.listApp.presentation.presenter

import android.util.Log
import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.domain.kakaoSearch.KakaoSearchUseCase
import com.min.listApp.presentation.constract.MainConstract

class MainPresenter(override var view: MainConstract.View) : MainConstract.Presenter {

    override fun start() {
        view.initLayout()
    }

    override fun end() {

    }

}