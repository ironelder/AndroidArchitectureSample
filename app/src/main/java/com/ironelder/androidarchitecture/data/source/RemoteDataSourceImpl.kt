package com.ironelder.androidarchitecture.data.source

import com.ironelder.androidarchitecture.data.service.NetworkService
import com.ironelder.androidarchitecture.data.entity.Contents
import retrofit2.Call

object RemoteDataSourceImpl : RemoteDataSource {
    override fun searchForKakao(category: String, query: String): Call<Contents> {
        return NetworkService.searchAPI.search(category, query)
    }
}