package com.min.listApp.data.model

data class KakaoImageListItemModel(
    val collection: String,
    val thumbnail_url: String,
    val image_url: String,
    val width: Int,
    val height: Int,
    val display_sitename: String,
    val doc_url: String,
    val datetime: String
) : KakaoListItemModel