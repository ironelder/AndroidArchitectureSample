package com.ironelder.androidarchitecture.component

import com.ironelder.androidarchitecture.common.REST_API_KEY
import com.ironelder.androidarchitecture.data.model.DataModel
import retrofit2.Call
import retrofit2.http.*

interface NetworkInterface {

    @Headers("Authorization: KakaoAK $REST_API_KEY")
    @GET("v2/search/{category}")
    fun search(@Path("category") category:String, @Query("query") query:String):Call<DataModel>

}