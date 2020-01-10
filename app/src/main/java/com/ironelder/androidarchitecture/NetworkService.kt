package com.ironelder.androidarchitecture

import retrofit2.Retrofit

object NetworkService {
    val searchAPI: NetworkInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(CLIENT_BASE_URL)
            .build()
        return@lazy retrofit.create(NetworkInterface::class.java)
    }
}