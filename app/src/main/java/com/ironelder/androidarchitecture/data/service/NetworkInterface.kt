package com.ironelder.androidarchitecture.data.service

import com.ironelder.androidarchitecture.common.REST_API_KEY
import com.ironelder.androidarchitecture.data.entity.Contents
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {

    @Headers("Authorization: KakaoAK $REST_API_KEY")
    @GET("v2/search/{category}")
    fun search(@Path("category") category: String, @Query("query") query: String): Single<Contents>

}