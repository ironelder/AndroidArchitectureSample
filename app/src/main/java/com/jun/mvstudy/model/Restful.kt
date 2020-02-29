package com.jun.mvstudy.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Restful {
    companion object {
        fun initializeApi() {

        }

        //------------------------------
        // Retrofit Core
        //------------------------------

        fun buildRetrofit(apiServerUrl: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(apiServerUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
        }
    }
}