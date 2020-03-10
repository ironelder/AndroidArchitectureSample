package com.ironelder.androidarchitecture.data.repository

import com.ironelder.androidarchitecture.data.entity.Contents
import com.ironelder.androidarchitecture.data.source.RemoteDataSourceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteRepositoryImpl : RemoteRepository {
    override fun searchForKakao(
        category: String,
        query: String
    ):Call<Contents> {
        return RemoteDataSourceImpl.searchForKakao(category, query)
    }
}