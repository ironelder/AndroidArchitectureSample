package com.ironelder.androidarchitecture

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    val searchAPI: NetworkInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(CLIENT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(NetworkInterface::class.java)
    }
}