package com.min.listApp.data.model

data class KakaoBlogListItemModel(
    val blogname: String,
    val contents: String,
    val datetime: String,
    val thumbnail: String,
    val title: String,
    val url: String
) : KakaoListItemModel