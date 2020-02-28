package com.min.listApp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchRetrofit {

    //TODO Class::class.java  ㅇㅣ게 무슨 뜻?
    fun getService(): RetrofitService = retrofit.create(
        RetrofitService::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com") // 도메인 주소
            .addConverterFactory(GsonConverterFactory.create()) // GSON을 사요아기 위해 ConverterFactory에 GSON 지정
            .build()
}