package com.ironelder.androidarchitecture.data.source

import com.ironelder.androidarchitecture.component.NetworkService
import com.ironelder.androidarchitecture.data.model.DataModel
import retrofit2.Call

object RemoteDataSourceImpl : RemoteDataSource{
    override fun searchForKakao(category: String, query: String): Call<DataModel> {
        return NetworkService.searchAPI.search(category, query)
    }
}