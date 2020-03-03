package com.ironelder.androidarchitecture.data.repository

import com.ironelder.androidarchitecture.data.entity.Contents
import com.ironelder.androidarchitecture.data.source.RemoteDataSourceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteRepositoryImpl : RemoteRepository {
    override fun searchForKakao(
        category: String,
        query: String,
        success: (result: Contents) -> Unit,
        failed: (message: String) -> Unit
    ) {
        RemoteDataSourceImpl.searchForKakao(category, query).enqueue(object : Callback<Contents> {
            override fun onFailure(call: Call<Contents>, t: Throwable) {
                t.message?.let(failed)
            }

            override fun onResponse(call: Call<Contents>, response: Response<Contents>) {
                response.body()?.let(success)
            }
        })
    }
}