package com.jun.mvstudy.di

import com.jun.mvstudy.model.service.KakaoSearchService
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var retrofitModule = module {
    single<KakaoSearchService> {
        Retrofit.Builder().baseUrl("https://dapi.kakao.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(KakaoSearchService::class.java)
    }
}

var studyModule = listOf(retrofitModule)