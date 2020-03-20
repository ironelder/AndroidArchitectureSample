package com.min.listApp.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    val kakaoSearchAPI: KakaoSearchInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(KAKAO_SEARCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return@lazy retrofit.create(KakaoSearchInterface::class.java)
    }
}