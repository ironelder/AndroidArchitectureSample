package com.min.listApp.data.model

data class KakaoVclipListItemModel(
    val author: String,
    val datetime: String,
    val play_time: Int,
    val thumbnail: String,
    val title: String,
    val url: String
) : KakaoListItemModel