package com.jun.mvstudy.mvp

import com.jun.mvstudy.model.response.ImageSearchResponse
import io.reactivex.Single

interface IMvpActivityPresenter {
    fun requestKakaoList(searchWord: String)
}