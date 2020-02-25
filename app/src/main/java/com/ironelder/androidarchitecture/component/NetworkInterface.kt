package com.ironelder.androidarchitecture.component

import com.ironelder.androidarchitecture.common.REST_API_KEY
import com.ironelder.androidarchitecture.model.DataModel
import retrofit2.Call
import retrofit2.http.*

interface NetworkInterface {

    @Headers("Authorization: KakaoAK $REST_API_KEY")
    @GET("v2/search/{type}")
    fun search(@Path("type") type:String, @Query("query") query:String):Call<DataModel>

}