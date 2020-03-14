package com.min.listApp.data.model

data class KakaoTipListItemModel(
    val a_url: String,
    val contents: String,
    val datetime: String,
    val q_url: String,
    val thumbnails: List<Any>,
    val title: String,
    val type: String
)