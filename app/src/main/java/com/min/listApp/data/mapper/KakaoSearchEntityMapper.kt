package com.min.listApp.data.mapper

import com.min.listApp.data.common.KakaoCategory
import com.min.listApp.data.entity.KakaoSearchDocumentEntity
import com.min.listApp.data.entity.KakaoSearchEntity
import com.min.listApp.data.entity.KakaoSearchMetaEntity
import com.min.listApp.data.model.*

object KakaoSearchEntityMapper {
    private fun <T : KakaoListItemModel> toImageListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<T> = documents.mapTo(destination = arrayListOf()) {
        KakaoImageListItemModel(
            collection = it.collection,
            datetime = it.datetime,
            display_sitename = it.display_sitename,
            doc_url = it.doc_url,
            height = it.height,
            image_url = it.image_url,
            thumbnail_url = it.thumbnail_url,
            width = it.width
        )
    }
//        documents.mapTo(destination = ArrayList()) {
//            return@mapTo ArrayList<T>()
//        }

    private fun toVClipListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoVclipListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            KakaoVclipListItemModel(author = it.author, datetime = it.datetime, play_time = it.play_time, thumbnail = it.thumbnail, title = it.title, url = it.url)
        }

    private fun toWebListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoWebListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            KakaoWebListItemModel(contents = it.contents, url = it.url, title = it.title, datetime = it.datetime)
        }

    private fun toBlogListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoBlogListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            KakaoBlogListItemModel(blogname = it.blogname, datetime = it.datetime, title = it.title, url = it.url, contents = it.contents, thumbnail = it.thumbnail)
        }

    private fun toTipListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoTipListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            KakaoTipListItemModel(a_url = it.a_url, contents = it.contents, title = it.title, datetime = it.datetime, q_url = it.q_url, thumbnails = it.thumbnails, type = it.type)
        }

    private fun toCafeListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoCafeListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            KakaoCafeListItemModel(cafename = it.cafename, url = it.url, thumbnail = it.thumbnail, contents = it.contents, title = it.contents, datetime = it.datetime)
        }

    private fun toBookListItem(documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoBookListItemModel> =
        documents.mapTo(destination = ArrayList()) {
            KakaoBookListItemModel(
                authors = it.authors,
                datetime = it.datetime,
                title = it.title,
                contents = it.contents,
                thumbnail = it.thumbnail,
                url = it.url,
                isbn = it.isbn,
                price = it.price,
                publisher = it.publisher,
                sale_price = it.sale_price,
                status = it.status,
                translators = it.translators
            )
        }

//    private fun toListItem(category: KakaoCategory, documents: List<KakaoSearchDocumentEntity>): ArrayList<KakaoListItemModel> {
//        when (category) {
//            KakaoCategory.IMAGE -> return toImageListItem(documents = documents)
//            KakaoCategory.BLOG -> return toBlogListItem(documents = documents)
//            KakaoCategory.BLOG -> return toBlogListItem(documents = documents)
//        }
//    }

    private fun toListMeta(meta: KakaoSearchMetaEntity): KakaoListMeta = meta.let {
        KakaoListMeta(
            total_count = it.total_count,
            is_end = it.is_end,
            pageable_count = it.pageable_count
        )
    }

    fun toListModel(entity: KakaoSearchEntity, category: KakaoCategory): KakaoListModel<KakaoListItemModel> = KakaoListModel(
        toListMeta(entity.meta), toImageListItem(documents = entity.documents)
    )
}