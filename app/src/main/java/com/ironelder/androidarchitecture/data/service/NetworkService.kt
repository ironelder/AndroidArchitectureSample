package com.ironelder.androidarchitecture.data.service

import com.ironelder.androidarchitecture.BuildConfig
import com.ironelder.androidarchitecture.common.CLIENT_BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkService {
    val searchAPI: NetworkInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(CLIENT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()
        return@lazy retrofit.create(NetworkInterface::class.java)
    }
    private val mOkHttpClient: OkHttpClient by lazy {
        val httpClient = OkHttpClient.Builder().apply {
            connectTimeout(30L, TimeUnit.SECONDS)
            readTimeout(30L, TimeUnit.SECONDS)
            addNetworkInterceptor(getLogInterceptor())
            addInterceptor(getSearchInterceptor())
        }
        return@lazy httpClient.build()
    }

    private fun getLogInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    private fun getSearchInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}