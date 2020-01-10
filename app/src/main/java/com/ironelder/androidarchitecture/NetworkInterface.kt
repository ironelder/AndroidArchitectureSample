package com.ironelder.androidarchitecture

import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkInterface {

    @GET("v2/search/{type}")
    fun search(@Path("type") type:String, query:String)

}