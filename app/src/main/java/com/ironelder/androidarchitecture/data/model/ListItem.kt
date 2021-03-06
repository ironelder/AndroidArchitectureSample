package com.ironelder.androidarchitecture.data.model

data class ListItem(
    val contents: String,
    val datetime: String,
    val title: String,
    val thumbnail: String,
    val url: String,
    val play_time: Int,
    val author: String
)