package com.min.listApp.data.source.call

import com.min.listApp.data.repository.KakaoSearchFailure
import com.min.listApp.data.repository.KakaoSearchResponse

abstract class KakaoDataSourceCallable {
    var succeedCallback: KakaoSearchResponse? = null
    var errorCallback: KakaoSearchFailure? = null
    abstract fun execute()
}