package com.jun.mvstudy.mvp

import android.util.Log
import com.jun.mvstudy.model.response.ImageSearchResponse
import com.jun.mvstudy.model.service.KakaoSearchService
import com.jun.mvstudy.ui.StudySearchAdapter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MvpPresenter(view: IMvpView, service: KakaoSearchService) : IMvpActivityPresenter {
    var mvpView = view
    var repository = service
    private val KAKAO_APP_KEY = "291b5c766ae8559dff14d5e1ae0e8ee6"

    override fun requestKakaoList(searchWord: String) {
         repository.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = searchWord, sort = "accuracy", page = 1, size = 1).subscribeOn(
            Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("jun", "list = " + it.documents.toString())
                var imageItem = StudySearchAdapter.ImageItem(it.documents[0].image_url, it.documents[0].display_sitename)
                mvpView.setKakaoData(imageItem)

            }, {
                Log.e("jun", "fail")
            })
    }
}