package com.min.listApp.data.source.call

import com.min.listApp.data.entity.KakaoSearchEntity

class KakaoCacheCall(val searchEntity: KakaoSearchEntity) : KakaoDataSourceCallable() {
    override fun execute() {
        //캐시는 구현하지 않음
        succeedCallback?.let { it(searchEntity) }
    }
}