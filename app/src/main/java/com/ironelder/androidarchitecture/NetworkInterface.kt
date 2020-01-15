package com.ironelder.androidarchitecture

import retrofit2.Call
import retrofit2.http.*

interface NetworkInterface {

    @Headers("Authorization: KakaoAK $REST_API_KEY")
    @GET("v2/search/{type}")
    fun search(@Path("type") type:String, @Query("query") query:String):Call<DataModel>

}