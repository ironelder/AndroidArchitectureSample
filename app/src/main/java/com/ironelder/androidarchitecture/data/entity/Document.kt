package com.ironelder.androidarchitecture.data.entity

data class Document(
    val contents: String?,
    val datetime: String?,
    val title: String?,
    val thumbnail: String?,
    val thumbnail_url: String?,
    val display_sitename: String?,
    val collection: String?,
    val url: String?,
    val play_time: Int?,
    val author: String?
)