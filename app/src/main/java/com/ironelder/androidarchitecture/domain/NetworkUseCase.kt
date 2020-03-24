package com.ironelder.androidarchitecture.domain

import com.ironelder.androidarchitecture.common.BLOG_TAB
import com.ironelder.androidarchitecture.common.CAFE_TAB
import com.ironelder.androidarchitecture.common.IMAGE_TAB
import com.ironelder.androidarchitecture.common.WEB_TAB
import com.ironelder.androidarchitecture.data.entity.Contents
import com.ironelder.androidarchitecture.data.model.DataModel
import com.ironelder.androidarchitecture.data.model.ListItem
import com.ironelder.androidarchitecture.data.repository.RemoteRepositoryImpl
import io.reactivex.Single

class NetworkUseCase {
    fun getSearchDataUseCase(
        category: String,
        query: String
    ): Single<DataModel> {
        return RemoteRepositoryImpl.searchForKakao(category, query).map { it ->
            when (category) {
                WEB_TAB -> DataModel(mappingBlogDataModel(it), it.meta.is_end)
                IMAGE_TAB -> DataModel(mappingImageDataModel(it), it.meta.is_end)
                BLOG_TAB -> DataModel(mappingBlogDataModel(it), it.meta.is_end)
                CAFE_TAB -> DataModel(mappingBlogDataModel(it), it.meta.is_end)
                else -> DataModel(mappingBlogDataModel(it), it.meta.is_end)
            }
        }
    }

    private fun mappingBlogDataModel(data: Contents) = data.documents.map {
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

    private fun mappingImageDataModel(data: Contents) = data.documents.map {
        ListItem(
            contents = it.collection ?: "",
            datetime = it.datetime ?: "",
            title = it.display_sitename ?: "",
            thumbnail = it.thumbnail_url ?: "",
            url = it.url ?: "",
            play_time = it.play_time ?: 0,
            author = it.author ?: ""
        )
    }
}