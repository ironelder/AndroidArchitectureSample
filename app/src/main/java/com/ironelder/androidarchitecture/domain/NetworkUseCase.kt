package com.ironelder.androidarchitecture.domain

import com.ironelder.androidarchitecture.data.entity.Contents
import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.data.repository.RemoteRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkUseCase {
    fun getSearchDataUseCase(
        category: String,
        query: String,
        success: (result: DataModel) -> Unit,
        failed: (message: String) -> Unit
    ) {
        RemoteRepositoryImpl.searchForKakao(category, query).enqueue(object : Callback<Contents> {
            override fun onFailure(call: Call<Contents>, t: Throwable) {
                t.message?.let(failed)
            }

            override fun onResponse(call: Call<Contents>, response: Response<Contents>) {
                response.body()?.let{
                    success(DataModel(mappingDataModel(it), it.meta.is_end))
                }
            }
        })
    }

    private fun mappingDataModel(data: Contents) = data.documents.map {
        ListItem(
            contents = it.contents ?: "",
            datetime = it.datetime ?: "",
            title = it.title ?: "",
            thumbnail = it.thumbnail ?: "",
            url = it.url ?: "",
            play_time = it.play_time ?: 0,
            author = it.author ?: ""
        )
    }
}