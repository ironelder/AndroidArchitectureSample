package com.min.listApp.data.network

import com.min.listApp.data.model.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val KAKAO_SEARCH_BASE_URL = "https://dapi.kakao.com"
const val KAKAO_REST_API_KEY = "29ce59a29dc4077804f3c4b8a5ba7ff2"
const val KAKAO_REST_API_HEADER = "Authorization: KakaoAK $KAKAO_REST_API_KEY"

interface KakaoSearchInterface {
    @Headers(KAKAO_REST_API_HEADER)
    @GET("/v2/search/image")
    fun requestSearchImage(
        @Query("query") keyword: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int,
        @Query("size") size: Int = 10
    ): Call<Image>
}