package com.min.listApp.data.model

data class KakaoWebListItemModel(
    val contents: String,
    val datetime: String,
    val title: String,
    val url: String
) : KakaoListItemModel