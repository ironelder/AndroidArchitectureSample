package com.ironelder.androidarchitecture.data.repository

import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.data.source.RemoteDataSourceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RemoteRepositoryImpl : RemoteRepository {
    override fun searchForKakao(
        category: String,
        query: String,
        success: (result: DataModel) -> Unit,
        failed: (message: String) -> Unit
    ) {
        RemoteDataSourceImpl.searchForKakao(category, query).enqueue(object : Callback<DataModel> {
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                t.message?.let(failed)
            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                response.body()?.let(success)
            }
        })
    }
}