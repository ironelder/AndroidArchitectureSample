package com.min.listApp.data.mapper

import com.min.listApp.data.entity.KakaoSearchDocumentEntity
import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.entity.KakaoSearchMetaEntity
import com.min.listApp.data.model.ImageListItemModel
import com.min.listApp.data.model.ImageListMetaModel
import com.min.listApp.data.model.ImageListModel

object KakaoSearchEntityMapper {
    private fun toImageListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<ImageListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            ImageListItemModel(
                collection = it.collection,
                thumbnail_url = it.thumbnail_url,
                datetime = it.datetime,
                display_sitename = it.display_sitename,
                doc_url = it.doc_url,
                height = it.height,
                image_url = it.image_url,
                width = it.width
            )
        }

    private fun toImageListMeta(meta: KakaoSearchMetaEntity): ImageListMetaModel = meta.let {
        ImageListMetaModel(
            total_count = it.total_count,
            is_end = it.is_end,
            pageable_count = it.pageable_count
        )
    }

    fun toImageListModel(entity: KakaoSearchEntity): ImageListModel = ImageListModel(
        toImageListMeta(entity.meta), toImageListItem(entity.documents)
    )
}