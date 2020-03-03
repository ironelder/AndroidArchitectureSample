package com.ironelder.androidarchitecture.component

import android.util.Log
import com.ironelder.androidarchitecture.data.entity.Contents
import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.data.repository.RemoteRepositoryImpl

class NetworkUseCase {
    fun getSearchDataUseCase(
        category: String,
        query: String,
        success: (result: DataModel) -> Unit,
        failed: (message: String) -> Unit
    ) {
        RemoteRepositoryImpl.searchForKakao(category, query, {
            success(DataModel(mappingDataModel(it), it.meta.is_end))
        }, failed)
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