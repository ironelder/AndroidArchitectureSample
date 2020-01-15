package com.ironelder.androidarchitecture

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {

    @GET("v2/search/{type}")
    fun search(@Path("type") type:String, @Query("query") query:String):Call<Any>

}