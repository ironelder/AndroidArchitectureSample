package com.ironelder.androidarchitecture.data.source

import com.ironelder.androidarchitecture.data.entity.Contents
import retrofit2.Call

interface RemoteDataSource {
    fun searchForKakao(category: String, query: String): Call<Contents>
}