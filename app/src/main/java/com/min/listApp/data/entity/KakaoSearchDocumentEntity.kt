package com.min.listApp.data.entity

data class KakaoSearchDocumentEntity(
    //Document
    val title: String,
    val contents: String,
    val url: String,
    val play_time: Int,
    val thumbnail: String,
    val author: String,
    val collection: String,
    val thumbnail_url: String,
    val image_url: String,
    val width: Int,
    val height: Int,
    val display_sitename: String,
    val doc_url: String,
    val datetime: String,
    val blogname: String,
    val q_url: String,
    val a_url: String,
    val thumbnails: List<String>,
    val type: String,
    val isbn: String,
    val authors: List<String>,
    val publisher: String,
    val translators: List<String>,
    val price: Int,
    val sale_price: Int,
    val status: String,
    val cafename: String
)